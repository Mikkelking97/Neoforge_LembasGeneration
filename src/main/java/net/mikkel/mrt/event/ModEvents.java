package net.mikkel.mrt.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.item.ModItems;
import net.mikkel.mrt.potion.ModPotions;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;


@EventBusSubscriber(modid = LembasBreadMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents
{
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event)
    {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.WITHER_SKELETON_SKULL, ModPotions.SUFFER_POTION);
        builder.addMix(Potions.WATER, ModItems.POTIONPRIMER.get(), Potions.AWKWARD);
        builder.addMix(Potions.AWKWARD, Items.NETHER_STAR, ModPotions.ASTRALTRAVEL_POTION);

        //Flight Potions
        builder.addMix(Potions.LEAPING, Items.FEATHER, ModPotions.LESSER_FLIGHT_POTION);
        builder.addMix(ModPotions.LESSER_FLIGHT_POTION, Items.WIND_CHARGE, ModPotions.GREATER_FLIGHT_POTION);
        builder.addMix(ModPotions.GREATER_FLIGHT_POTION, Items.PHANTOM_MEMBRANE, ModPotions.SUPREME_FLIGHT_POTION);

    }

    // Normal Traders
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event)
    {
        if(event.getType() == VillagerProfession.CLERIC)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 24),
                    new ItemStack(Items.BLAZE_ROD, 1), 2, 50, 2));

        }


        if(event.getType() == VillagerProfession.ARMORER)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUM_CHESTPLATE.get(), 1), 1, 500, 1));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUM_BOOTS.get(), 1), 1, 500, 1));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUM_LEGGINGS.get(), 1), 1, 500, 1));

            trades.get(5).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUM_HELMET.get(), 1), 1, 500, 1));

        }


        if(event.getType() == VillagerProfession.WEAPONSMITH)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUMSWORD.get(), 1), 1, 500, 1));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUMAXE.get(), 1), 1, 500, 1));
        }


        if(event.getType() == VillagerProfession.TOOLSMITH)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUMPICKAXE.get(), 1), 1, 500, 1));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUMAXE.get(), 1), 1, 500, 1));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUMHOE.get(), 1), 1, 500, 1));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 64),
                    new ItemStack(ModItems.DURANIUMSHOVEL.get(), 1), 1, 500, 1));
        }


        if(event.getType() == VillagerProfession.FARMER)
        {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 7),
                    new ItemStack(ModItems.LEMBASBREAD.get(), 1), 10, 100, 0.05f));

            trades.get(2).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 12),
                    new ItemStack(ModItems.LEMBASBREAD.get(), 2), 8, 200, 0.05f));

            trades.get(3).add((entity, randomSource) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 15),
                    new ItemStack(ModItems.LEMBASBREAD.get(), 3), 6, 300, 0.05f));
        }

    }

    //Villager passive healing
    /*@SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event)
    {
        if (!(event.getEntity() instanceof Villager villager))
            return;

        //Heal every 10 seconds
        if (villager.tickCount % 200 == 0)
        {
            //Debug to verify it works.
            System.out.println("Villager HP: " + villager.getHealth());

            if(villager.getHealth() < villager.getMaxHealth())
            {
                villager.heal(1.0f);
                System.out.println("After heal: " + villager.getHealth());
            }
        }
    }*/

    //Wandering Trader
    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event)
    {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 38),
                new ItemStack(Items.BLAZE_ROD, 1), 2, 100, 0.2f));

        rareTrades.add((entity, randomSource) -> new MerchantOffer(
                new ItemCost(Items.NETHERITE_INGOT, 1),
                new ItemStack(ModItems.DURANIUMCLUMP.get(), 7), 2, 1000, 0.2f));
    }


}
