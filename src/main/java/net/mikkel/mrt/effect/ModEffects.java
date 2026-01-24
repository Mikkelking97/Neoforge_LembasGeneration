package net.mikkel.mrt.effect;


import net.mikkel.mrt.LembasBreadMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.FastColor;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Mob;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.jar.Attributes;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, LembasBreadMod.MODID);

    //.addAttributeModifier Allows to edit the living entitie modifiers.
    public static final Holder<MobEffect> SUFFER_EFFECT = MOB_EFFECTS.register("suffer",
            () -> new Suffer_Effect(MobEffectCategory.HARMFUL, 1));

    //The Effect art 18 by 18, must match the Effect ID. "astraltravel". //61838 Nice green
    public static final Holder<MobEffect> AstralTravel_Effect = MOB_EFFECTS.register("astraltravel",
            () -> new AstralTravel_Effect(MobEffectCategory.BENEFICIAL, 0x40E0D0));


    public static final Holder<MobEffect> LIGHTNINGINBOTTLE = MOB_EFFECTS.register("lightning",
            () -> new LightningInBottle_Effect(MobEffectCategory.HARMFUL, FastColor.ARGB32.color(50, 100, 100, 100)));


    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
