package net.mikkel.mrt.effect;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class Biome_Soul_Valley_Effect extends MobEffect
{
    public Biome_Soul_Valley_Effect(MobEffectCategory category, int color)
    {
        super(category, color);
    }


    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier)
    {
        if (!livingEntity.level().isClientSide())
        {
            if (livingEntity.getServer() != null)
            {
                livingEntity.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                                livingEntity.createCommandSourceStack(),
                                "fillbiome ~-15 ~-15 ~-15 ~15 ~15 ~15 minecraft:soul_sand_valley"
                        );
            }
        }

        return true;
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier)
    {
        return true;
    }
}