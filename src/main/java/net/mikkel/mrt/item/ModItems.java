package net.mikkel.mrt.item;

import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.item.custom.FuelItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.List;

public class ModItems
{

    //Food Items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LembasBreadMod.MODID);

    public  static final DeferredItem<Item> LEMBASBREAD = ITEMS.register("lembas_bread",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationModifier(30)
                    .build()))

            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembas_bread")
                            .withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
                }
            }
    );

    public  static final DeferredItem<Item> INVERTEDLEMBAS = ITEMS.register("inverted_lembas",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .build())));


    //Ores Etc
    public static final DeferredItem<Item> DURANIUMINGOT = ITEMS.register("duranium_ingot",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duranium_ingot")
                            .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
                }
            }
    );


    public static final DeferredItem<Item> DURANIUMCLUMP = ITEMS.register("duranium_clump",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duranium_clump")
                            .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
                }
            }
    );


    public static final DeferredItem<Item> ROUGHDURANIUMINGOT = ITEMS.register("rough_duranium_ingot",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.rough_duranium_ingot")
                            .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
                }
            }
    );

    public static final DeferredItem<Item> TEMPEREDDURANIUMINGOT = ITEMS.register("tempered_duranium_ingot",
            () -> new Item(new Item.Properties())
            {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.tempered_duranium_ingot")
                            .withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
                }
            }
    );

    public static final DeferredItem<Item> TONG = ITEMS.register("tong",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FORGEHAMMER = ITEMS.register("forge_hammer",
            () -> new Item(new Item.Properties()));

    //Potions
    public static final DeferredItem<Item> POTIONPRIMER = ITEMS.register("potion_primer",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALCHEMISTCOAL = ITEMS.register("alchemist_coal",
            ()-> new FuelItem(new Item.Properties(), 800));


    //Registering Tools
    public static final DeferredItem<PickaxeItem> DURANIUMPICKAXE = ITEMS.register("duranium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DURANIUM, new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.DURANIUM, 2, -1)))
            {
                @Override
                public boolean isBookEnchantable(ItemStack stack, ItemStack book)
                {
                    return false;
                }

                //appendHoverText is tooltext on item.
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duraniumpickaxe"));
                }
            });



    public static final DeferredItem<SwordItem> DURANIUMSWORD = ITEMS.register("duranium_sword",
            () -> new SwordItem(ModToolTiers.DURANIUM, new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .attributes(SwordItem.createAttributes(ModToolTiers.DURANIUM, 8, 1)))
            {
                @Override
                public boolean isBookEnchantable(ItemStack stack, ItemStack book)
                {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duraniumsword"));
                }
            });

    public static final DeferredItem<AxeItem> DURANIUMAXE = ITEMS.register("duranium_axe",
            () -> new AxeItem(ModToolTiers.DURANIUM, new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .attributes(AxeItem.createAttributes(ModToolTiers.DURANIUM, 10, -2)))
            {
                @Override
                public boolean isBookEnchantable(ItemStack stack, ItemStack book)
                {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duraniumaxe"));
                }
            });

    public static final DeferredItem<ShovelItem> DURANIUMSHOVEL = ITEMS.register("duranium_shovel",
            () -> new ShovelItem(ModToolTiers.DURANIUM, new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .attributes(ShovelItem.createAttributes(ModToolTiers.DURANIUM, 1.5f, -2)))
            {
                @Override
                public boolean isBookEnchantable(ItemStack stack, ItemStack book)
                {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duraniumshovel"));
                }
            });

    public static final DeferredItem<HoeItem> DURANIUMHOE = ITEMS.register("duranium_hoe",
            () -> new HoeItem(ModToolTiers.DURANIUM, new Item.Properties()
                    .fireResistant()
                    .rarity(Rarity.EPIC)
                    .attributes(HoeItem.createAttributes(ModToolTiers.DURANIUM, -4, 0)))
            {
                @Override
                public boolean isBookEnchantable(ItemStack stack, ItemStack book)
                {
                    return false;
                }

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duraniumhoe"));
                }
            });

    //Registering Armour
    //Helmet
public static  final DeferredItem<ArmorItem> DURANIUM_HELMET = ITEMS.register("duranium_helmet",
            () -> new ArmorItem(ModArmorMaterials.DURANIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .durability(ArmorItem.Type.HELMET.getDurability(600))));

    //Chestplate
    public static  final DeferredItem<ArmorItem> DURANIUM_CHESTPLATE = ITEMS.register("duranium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DURANIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .durability(ArmorItem.Type.CHESTPLATE.getDurability(600)))
            {
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
                {
                    tooltipComponents.add(Component.translatable("tooltip.lembasbreadmod.duranium_chestplate"));
                }
            });



    //Leggings
    public static  final DeferredItem<ArmorItem> DURANIUM_LEGGINGS = ITEMS.register("duranium_leggings",
            () -> new ArmorItem(ModArmorMaterials.DURANIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .durability(ArmorItem.Type.LEGGINGS.getDurability(600))));

    public static  final DeferredItem<ArmorItem> DURANIUM_BOOTS = ITEMS.register("duranium_boots",
            () -> new ArmorItem(ModArmorMaterials.DURANIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .durability(ArmorItem.Type.BOOTS.getDurability(600))));





    public static void register (IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
