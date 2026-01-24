package net.mikkel.mrt.potion;


import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModPotions
{
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, LembasBreadMod.MODID);

    //Suffer Potion
    public static final Holder<Potion> SUFFER_POTION = POTIONS.register("suffer_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SUFFER_EFFECT, 1200, 0)));


    //Astral Potion
    public static final Holder<Potion> ASTRALTRAVEL_POTION = POTIONS.register("astraltravel_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.AstralTravel_Effect, 1200, 0)));


    //Lightning Potion
    public static final Holder<Potion> LIGHTNINGINBOTTLE = POTIONS.register("lightninginbottle_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.LIGHTNINGINBOTTLE, 1200, 0)));

    /*//BONEMEALPOTION AKA FLOURISHING POTION
    public static final Holder<Potion> FLOURISHING_POTION = POTIONS.register("flourishing_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FLOURISHING_EFFECT, 1200, 0))); */

    //registering
    public static void register(IEventBus eventBus)
    {
        POTIONS.register(eventBus);
    }

}
