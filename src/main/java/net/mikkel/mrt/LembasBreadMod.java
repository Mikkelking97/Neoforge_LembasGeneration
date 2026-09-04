package net.mikkel.mrt;


import net.mikkel.mrt.block.ModBlocks;
import net.mikkel.mrt.effect.AstralTravel_Effect;
import net.mikkel.mrt.effect.ModEffects;
import net.mikkel.mrt.entity.ModEntities;
import net.mikkel.mrt.entity.custom.DuraniumGolemEntity;
import net.mikkel.mrt.item.ModItems;
import net.mikkel.mrt.potion.ModPotions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import static net.mikkel.mrt.potion.ModPotions.*;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LembasBreadMod.MODID)
public class LembasBreadMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "mrt";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public LembasBreadMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the addtooltip for basically all items.
        NeoForge.EVENT_BUS.addListener(this::addtooltip);

        modEventBus.addListener(this::modifymaxpotionstack);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (Lembasbread) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        //Potions & Effects
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        //Entities
        ModEntities.register(modEventBus);
        modEventBus.addListener(this::registerattributes);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            //Food
            event.accept(ModItems.LEMBASBREAD);
            event.accept(ModItems.INVERTEDLEMBAS);

            //Ores
            event.accept(ModItems.DURANIUMINGOT);
            event.accept(ModItems.DURANIUMCLUMP);
            event.accept(ModItems.ROUGHDURANIUMINGOT);
            event.accept(ModItems.TEMPEREDDURANIUMINGOT);
            event.accept(ModItems.TONG);
            event.accept(ModItems.FORGEHAMMER);

            //Potion Related
            event.accept(ModItems.POTIONPRIMER);
            event.accept(ModItems.ALCHEMISTCOAL);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.DURANIUM_BLOCK);
            event.accept(ModBlocks.DURANIUM_ORE);
            event.accept(ModBlocks.FORGE_BLOCK);
        }
    }

    private void addtooltip(ItemTooltipEvent event)
    {
        ItemStack itemStack = event.getItemStack();
        if(itemStack.is(Items.POTION) || itemStack.is(Items.LINGERING_POTION) || itemStack.is(Items.SPLASH_POTION))
        {
            PotionContents potion = itemStack.get(DataComponents.POTION_CONTENTS);
            if (potion.is(ASTRALTRAVEL_POTION))
            {
                event.getToolTip().add(2,Component.translatable("tooltip.lembasbreadmod.astraltravel_potion")
                            .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));

            }

            else if (potion.is(LESSER_FLIGHT_POTION))
            {
                event.getToolTip().add(2, Component.translatable("tooltip.lembasbreadmod.lesser_flight_potion")
                        .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
            }

            else if (potion.is(GREATER_FLIGHT_POTION))
            {
                event.getToolTip().add(2, Component.translatable("tooltip.lembasbreadmod.greater_flight_potion")
                        .withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
            }

            else if (potion.is(SUPREME_FLIGHT_POTION))
            {
                event.getToolTip().add(2, Component.translatable("tooltip.lembasbreadmod.supreme_flight_potion")
                        .withStyle(ChatFormatting.LIGHT_PURPLE, ChatFormatting.OBFUSCATED));
            }
        }

    }

    //This method
    private void modifymaxpotionstack(ModifyDefaultComponentsEvent event)
    {
        event.modify(Items.POTION, builder ->
        {
            builder.set(DataComponents.MAX_STACK_SIZE, 8);
        });

        event.modify(Items.SPLASH_POTION, builder ->
        {
            builder.set(DataComponents.MAX_STACK_SIZE, 8);
        });

        event.modify(Items.LINGERING_POTION, builder ->
        {
            builder.set(DataComponents.MAX_STACK_SIZE, 8);
        });
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }

    private void registerattributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.DURANIUMGOLEM.get(), DuraniumGolemEntity.createAttributes().build());
    }
}
