package net.mikkel.mrt.datagen;


import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.item.ModItems;

import net.mikkel.mrt.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider
{

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, LembasBreadMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.TONG.get())
                .add(ModItems.FORGEHAMMER.get())
                .add(ModItems.DURANIUMCLUMP.get())
                .add(ModItems.ROUGHDURANIUMINGOT.get())
                .add(ModItems.TEMPEREDDURANIUMINGOT.get())
                .add(ModItems.DURANIUMINGOT.get())
                .add(ModItems.TEMPEREDDURANIUMINGOT.get())
                .add(ModItems.LEMBASBREAD.get())
                .add(ModItems.DURANIUMPICKAXE.get())
                .add(ModItems.POTIONPRIMER.get())
                .add(ModItems.ALCHEMISTCOAL.get());


        tag(ItemTags.PICKAXES)
                .add(ModItems.DURANIUMPICKAXE.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.DURANIUMSWORD.get());

        tag(ItemTags.AXES)
                .add(ModItems.DURANIUMAXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.DURANIUMSHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.DURANIUMHOE.get());

        //To make the armourset trimmable.
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.DURANIUM_HELMET.get())
                .add(ModItems.DURANIUM_CHESTPLATE.get())
                .add(ModItems.DURANIUM_LEGGINGS.get())
                .add(ModItems.DURANIUM_BOOTS.get());


    }
}
