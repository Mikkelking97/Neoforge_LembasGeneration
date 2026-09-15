package net.mikkel.mrt.worldgen;

import net.mikkel.mrt.LembasBreadMod;
import net.mikkel.mrt.entity.ModEntities;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers
{
    public static final ResourceKey<BiomeModifier> ADD_DURANIUM_ORE = registerKey("add_duranium_ore");
    //Can add Nether || End ores.

    //Spawning Duranium Golem
    public static final ResourceKey<BiomeModifier> SPAWN_DURANIUMGOLEM = registerKey("spawn_duraniumgolem");


    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        // CF -> PF -> BM
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_DURANIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DURANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //DuraniumSpawning
        context.register(SPAWN_DURANIUMGOLEM, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP),
                        biomes.getOrThrow(Biomes.PLAINS),
                        biomes.getOrThrow(Biomes.FOREST),
                        biomes.getOrThrow(Biomes.TAIGA),
                        biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.DARK_FOREST),
                        biomes.getOrThrow(Biomes.BADLANDS),
                        biomes.getOrThrow(Biomes.BASALT_DELTAS),
                        biomes.getOrThrow(Biomes.DESERT),
                        biomes.getOrThrow(Biomes.DEEP_DARK)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.DURANIUMGOLEM.get(), 20, 1, 2))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name)
    {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(LembasBreadMod.MODID, name));
    }

}
