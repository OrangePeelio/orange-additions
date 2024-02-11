package orangepeel.orangeadditions.ModContainer.TerrainAPI;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import orangepeel.orangeadditions.OrangeAdditions;
import useless.terrainapi.api.TerrainAPI;
import useless.terrainapi.generation.overworld.OverworldConfig;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

public class TerrainAPIPlugin implements TerrainAPI {
	@Override
	public String getModID(){
		return OrangeAdditions.MOD_ID;
	}
	public static final OverworldConfig overworldConfig = ChunkDecoratorOverworldAPI.overworldConfig;
	@Override
	public void onInitialize() {
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureFlowers(OrangeAdditions.whiteMushroom.id), 4, -1f, 1, new Biome[]{Biomes.OVERWORLD_FOREST, Biomes.OVERWORLD_PLAINS, Biomes.OVERWORLD_BIRCH_FOREST, Biomes.OVERWORLD_RAINFOREST, Biomes.OVERWORLD_SEASONAL_FOREST, Biomes.OVERWORLD_SWAMPLAND, Biomes.OVERWORLD_SWAMPLAND_MUDDY});

	}
}
