package net.mikkel.mrt.potion;


import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
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

    //Biome_Soulsand_Valley Potion
    //public static final Holder<Potion> SOUL_VALLEY_POTION = POTIONS.register("soul_valley_potion"),
    //() -> new Potion (new MobEffectInstance(ModEffects.SOUL_VALLEY_POTION, 1, 1, 0));

    //Flight Potions
    public static final Holder<Potion> SUPREME_FLIGHT_POTION = POTIONS.register("supreme_flight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.SUPREME_FLIGHT_EFFECT, 400, 0)));

    public static final Holder<Potion> GREATER_FLIGHT_POTION = POTIONS.register("greater_flight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.GREATER_FLIGHT_EFFECT, 200, 0),
            new MobEffectInstance(MobEffects.WEAKNESS, 200, 0)));

    public static final Holder<Potion> LESSER_FLIGHT_POTION = POTIONS.register("lesser_flight_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.LESSER_FLIGHT_EFFECT, 100, 0),
            new MobEffectInstance(MobEffects.WEAKNESS, 100, 0),
                    new MobEffectInstance(MobEffects.BLINDNESS, 100, 0)));

    //Hero of the Village
    public static final DeferredHolder<Potion, Potion> HERO_POTION_I = POTIONS.register("hero_potion_i",
            () -> new Potion(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,24000, 1)));

    public static final DeferredHolder<Potion, Potion> HERO_POTION_II = POTIONS.register("hero_potion_ii",
            () -> new Potion(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,24000, 2)));

    public static final DeferredHolder<Potion, Potion> HERO_POTION_III = POTIONS.register("hero_potion_iii",
            () -> new Potion(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,24000, 3)));

    public static final DeferredHolder<Potion, Potion> HERO_POTION_IV = POTIONS.register("hero_potion_iv",
            () -> new Potion(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,24000, 4)));

    public static final DeferredHolder<Potion, Potion> HERO_POTION_V = POTIONS.register("hero_potion_v",
            () -> new Potion(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,24000, 5)));

//Potions of Luck, Looting and Fortune
 public static final DeferredHolder<Potion, Potion> LIQUID_LUCK_I = POTIONS.register("liquid_luck_i",
            () -> new Potion(new MobEffectInstance(MobEffects.LUCK,72000, 254)));

    /*//BONEMEALPOTION AKA FLOURISHING POTION
    public static final Holder<Potion> FLOURISHING_POTION = POTIONS.register("flourishing_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.FLOURISHING_EFFECT, 1200, 0))); */

    //registering
    public static void register(IEventBus eventBus)
    {
        POTIONS.register(eventBus);
    }

}
