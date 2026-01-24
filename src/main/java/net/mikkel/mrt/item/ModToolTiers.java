package net.mikkel.mrt.item;

import net.mikkel.mrt.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers
{
    public static final Tier DURANIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_DURANIUM_TOOL,
            8000, 12f, 4f, 0, () -> Ingredient.of(ModItems.DURANIUMINGOT));
}
