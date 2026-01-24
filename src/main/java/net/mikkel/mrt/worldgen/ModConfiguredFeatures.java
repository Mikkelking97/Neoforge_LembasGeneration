package net.mikkel.mrt.worldgen;

import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures
{
    //Configured Feature -> Placed Feature -> Biome Modifier
    //Configured Feature example is like how is the tree going to look, or how many ores are going to spawn.
    //Placed Feature is where and how many do I place.
    //Biome Modifier is what biome is it in?

    public  static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DURANIUM_ORE_KEY = registerKey("duranium_ore");
    //public  static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_DURANIUM_ORE_KEY = registerKey("nether_duranium_ore");

    //Here we write our configured features that will be turned into Json files later.
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?,?>> context)
    {
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        //Define below
        List<OreConfiguration.TargetBlockState> overworldDuraniumOres = List.of
                (OreConfiguration.target(deepslateReplaceables, ModBlocks.DURANIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_DURANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldDuraniumOres, 9));
        //Could copypaste and adjust for Nether || End equivalent.
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(LembasBreadMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
