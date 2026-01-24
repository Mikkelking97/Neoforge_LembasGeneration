package net.mikkel.mrt.effect;


import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Suffer_Effect extends MobEffect
{
    public Suffer_Effect(MobEffectCategory category, int color)
    {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier)
    {

        if (!livingEntity.level().isClientSide())
        {
            // Damage scales with amplifier (optional)
            float damage = 3.0F + amplifier * 0.5F;
            livingEntity.hurt(livingEntity.damageSources().magic(), damage);
        }
        return true;
        //return super.applyEffectTick(livingEntity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier)
    {
        return true;
    }


}
