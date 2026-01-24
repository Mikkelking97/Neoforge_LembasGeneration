package net.mikkel.mrt.util;

import net.mikkel.mrt.LembasBreadMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        //I literally have a datagen for TAGS, no need to do it myself.
        public static final TagKey<Block> NEEDS_DURANIUM_TOOL = createTag("needs_duranium_tool");
        public static final TagKey<Block> INCORRECT_FOR_DURANIUM_TOOL = createTag("incorrect_for_duranium_tool");


        private  static TagKey<Block> createTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(LembasBreadMod.MODID, name));
        }

    }

    public  static class Items
    {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        private  static TagKey<Item> createTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(LembasBreadMod.MODID, name));
        }
    }
}
