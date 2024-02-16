package orangepeel.orangeadditions.ModContainer.TerrainAPI;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import orangepeel.orangeadditions.OrangeAdditions;
import orangepeel.orangeadditions.world.worldgen.WorldFeatureCrystal;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.Parameters;
import useless.terrainapi.generation.nether.api.ChunkDecoratorNetherAPI;
import useless.terrainapi.generation.overworld.OverworldConfig;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

public class TerrainAPIPlugin implements TerrainAPI {
	public static final OverworldConfig overworldConfig = ChunkDecoratorOverworldAPI.overworldConfig;
	@Override
	public String getModID() {
		return OrangeAdditions.MOD_ID;
	}

	@Override
	public void onInitialize() {
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(OrangeAdditions.whiteMushroom.id), 4, -1f, 1, new Biome[]{Biomes.OVERWORLD_FOREST, Biomes.OVERWORLD_PLAINS, Biomes.OVERWORLD_BIRCH_FOREST, Biomes.OVERWORLD_RAINFOREST, Biomes.OVERWORLD_SEASONAL_FOREST, Biomes.OVERWORLD_SWAMPLAND, Biomes.OVERWORLD_SWAMPLAND_MUDDY});
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureCrystal(OrangeAdditions.brightiteCrystal.id), 1, 1/3f);
		ChunkDecoratorNetherAPI.randomFeatures.addFeature(new WorldFeatureCrystal(OrangeAdditions.blightiteCrystal.id), 1, 1f);
		ChunkDecoratorNetherAPI.oreFeatures.addFeature(new WorldFeatureOre(OrangeAdditions.crimtane.id, 1, false), 6, 120 / 128f);

	}
}
