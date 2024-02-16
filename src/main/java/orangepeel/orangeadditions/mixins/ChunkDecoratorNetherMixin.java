package orangepeel.orangeadditions.mixins;


import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.ChunkDecorator;
import net.minecraft.core.world.generate.chunk.perlin.nether.ChunkDecoratorNether;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureFlowers;
import net.minecraft.core.world.generate.feature.WorldFeatureOre;
import orangepeel.orangeadditions.OrangeAdditions;
import orangepeel.orangeadditions.world.worldgen.WorldFeatureCrystal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ChunkDecoratorNether.class, remap = false)
public abstract class ChunkDecoratorNetherMixin implements ChunkDecorator {
	@Final
	private World world;

	@Inject(method = "decorate", at = @At("TAIL"))
	private void injectMethod(Chunk chunk, CallbackInfo info) {
		//define chunk vals
		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		//define absolute vals
		int x = chunkX << 4;
		int z = chunkZ << 4;
		//define random
		Random rand = new Random((long) chunkX * 341873128712L + (long) chunkZ * 132897987541L);
		//get Y range
		int minY = world.getWorldType().getMinY();
		int maxY = world.getWorldType().getMaxY();
		int rangeY = maxY + 1 - minY;


		int xf;
		int yf;
		int zf;

		if (rand.nextInt(2) == 0) {
			xf = x + rand.nextInt(16) + 8;
			zf = z + rand.nextInt(16) + 8;
			yf = minY + rand.nextInt(rangeY - 8) + 4;
			new WorldFeatureCrystal(OrangeAdditions.blightiteCrystal.id).generate(world, rand, xf, yf, zf);
		}
		if (rand.nextInt(12) == 0) {
			xf = x + rand.nextInt(16);
			yf = minY + rand.nextInt(rangeY - 8) + 4;
			zf = z + rand.nextInt(16);
			new WorldFeatureOre(OrangeAdditions.crimtane.id, 16+rand.nextInt(16), false).generate(this.world, rand, xf, yf, zf);
		}
	}
}
