package net.mikkel.mrt.effect;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;

public class LightningInBottle_Effect extends InstantenousMobEffect
{
    public LightningInBottle_Effect(MobEffectCategory mobEffectCategory, int color)
    {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier)
    {
        if (!entity.level().isClientSide()) //If its not ran on the client
        {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(entity.level());
            if (lightning != null)
            {
                lightning.moveTo(entity.getX(), entity.getY(), entity.getZ()); //Entity is the person with the effect
                lightning.setVisualOnly(false); // Deal damage
                entity.level().addFreshEntity(lightning);
            }
        }
        return false; //should be return false
    }

}
