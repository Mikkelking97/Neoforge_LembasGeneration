package net.mikkel.mrt.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.EventHooks;

public class DuraniumGolemLookAtPlayerGoal extends LookAtPlayerGoal
{

    public DuraniumGolemLookAtPlayerGoal(Mob mob, Class<? extends LivingEntity> lookAtType, float lookDistance)
    {
        super(mob, lookAtType, lookDistance, 0.8f);


    }

    @Override
    public void tick()
    {
        super.tick();

        if (EventHooks.canEntityGrief(mob.level(), mob))
        {
            boolean flag = false;
            int l = Mth.floor(this.mob.getBbWidth() / 2.0F + 1.0F);
            int i1 = Mth.floor(this.mob.getBbHeight());

            for(BlockPos blockpos : BlockPos.betweenClosed(this.mob.getBlockX() - l, this.mob.getBlockY(), this.mob.getBlockZ() - l, this.mob.getBlockX() + l, this.mob.getBlockY() + i1, this.mob.getBlockZ() + l))
            {
                BlockState blockstate = this.mob.level().getBlockState(blockpos);
                if (blockstate.canEntityDestroy(this.mob.level(), blockpos, mob) && EventHooks.onEntityDestroyBlock(mob, blockpos, blockstate))
                {
                    flag = this.mob.level().destroyBlock(blockpos, true, mob) || flag;
                }
            }

            if (flag) {
                this.mob.level().levelEvent((Player)null, 1022, this.mob.blockPosition(), 0);
            }
        }
    }
}
