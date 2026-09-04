package net.mikkel.mrt.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.common.NeoForgeMod;

public class Greater_Flight_Effect extends MobEffect
{
    public Greater_Flight_Effect(MobEffectCategory category, int color)
    {
        super(category, color);

        this.addAttributeModifier(NeoForgeMod.CREATIVE_FLIGHT,
                ResourceLocation.fromNamespaceAndPath("mrt", "creative_flight"),
                1.0,
                AttributeModifier.Operation.ADD_VALUE);
    }
}
