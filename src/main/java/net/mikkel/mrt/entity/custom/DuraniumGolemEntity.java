package net.mikkel.mrt.entity.custom;

import net.mikkel.mrt.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import org.jetbrains.annotations.Nullable;

public class DuraniumGolemEntity extends IronGolem
{

    //Theese 2 are the field of my Golem class.
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    //This is the constructor of my Golem class.
    public DuraniumGolemEntity(EntityType<? extends IronGolem> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    protected void registerGoals()
    { //Lower Int = More priority.
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2));
        this.goalSelector.addGoal(2, new DuraniumGolemLookAtPlayerGoal(this, Player.class, 6.0f));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes()
    {   //Should this be "return Monster"? Instead?
        return IronGolem.createAttributes()
                .add(Attributes.MAX_HEALTH, 15d)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 24d);
    }


    @Override
    public void aiStep()
    {
        super.aiStep();

        Vec3 movement = this.getDeltaMovement();
        if (!this.onGround() && movement.y < (double)0.0F)
        {
            this.setDeltaMovement(movement.multiply((double)1.0F, 0.5, (double)1.0F));
        }
    }

    //Stolen EndermanLogic Hurt and Teleport
    private boolean teleport(double x, double y, double z) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(x, y, z);

        while(blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            EntityTeleportEvent.EnderEntity event = EventHooks.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) {
                return false;
            } else {
                Vec3 vec3 = this.position();
                boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
                if (flag2) {
                    this.level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                    if (!this.isSilent()) {
                        this.level().playSound((Player)null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
                        this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                    }
                }

                return flag2;
            }
        } else {
            return false;
        }
    }
    //TP Logic
    protected boolean teleport()
    {
        if (!this.level().isClientSide() && this.isAlive())
        {
            double d0 = this.getX() + (this.random.nextDouble() - (double)0.5F) * (double)64.0F;
            double d1 = this.getY() + (double)(this.random.nextInt(64) - 32);
            double d2 = this.getZ() + (this.random.nextDouble() - (double)0.5F) * (double)64.0F;
            return this.teleport(d0, d1, d2);
        } else
        {
            return false;
        }
    }
    //TP when Hurt
    @Override
    public boolean causeFallDamage(float fallDistance, float multiplier, DamageSource source)
    {
        return false;
    }

    public boolean hurt(DamageSource source, float amount)
    {
        if (this.isInvulnerableTo(source))
        {
            return false;
        } else
        {
            boolean flag = source.getDirectEntity() instanceof ThrownPotion;
            if (!source.is(DamageTypeTags.IS_PROJECTILE) && !flag) {
                boolean flag2 = super.hurt(source, amount);
                if (!this.level().isClientSide() && !(source.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
                    this.teleport();
                }

                return flag2;
            } else
            {
                boolean flag1 = flag;

                for(int i = 0; i < 64; ++i)
                {
                    if (this.teleport())
                    {
                        return true;
                    }
                }

                return flag1;
            }
        }
    }

    //StoleWitherBoss Destroyblock Logic
    private int destroyBlocksTick = 1;
    protected void customServerAiStep()
    {
        if (this.destroyBlocksTick > 0)
        {
            //--this.destroyBlocksTick;
            /*if (EventHooks.canEntityGrief(this.level(), this))
            {
                boolean flag = false;
                int l = Mth.floor(this.getBbWidth() / 2.0F + 1.0F);
                int i1 = Mth.floor(this.getBbHeight());

                for(BlockPos blockpos : BlockPos.betweenClosed(this.getBlockX() - l, this.getBlockY(), this.getBlockZ() - l, this.getBlockX() + l, this.getBlockY() + i1, this.getBlockZ() + l))
                {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    if (blockstate.canEntityDestroy(this.level(), blockpos, this) && EventHooks.onEntityDestroyBlock(this, blockpos, blockstate))
                    {
                        flag = this.level().destroyBlock(blockpos, true, this) || flag;
                    }
                }

                if (flag) {
                    this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                }
            }*/
    }

}


    private void setupAnimationStates()
    {
        if(this.idleAnimationTimeout <= 0)
        {
            this.idleAnimationTimeout = 80; // X seconds times 20 ticks = the integer to loop.
            this.idleAnimationState.start(this.tickCount);
        }
        else {--this.idleAnimationTimeout;}
    }

    @Override
    public void tick()
    {
        super.tick();

        if(this.level().isClientSide)
        {
            this.setupAnimationStates();
        }
    }
}
