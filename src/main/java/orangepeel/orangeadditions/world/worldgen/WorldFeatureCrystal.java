package orangepeel.orangeadditions.world.worldgen;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import orangepeel.orangeadditions.BlockCrystal;
import orangepeel.orangeadditions.OrangeAdditions;
import useless.terrainapi.generation.Parameters;

import java.util.Random;

public class WorldFeatureCrystal extends WorldFeature {

	private final int crystalBlockID;
	public WorldFeatureCrystal(int i){
		crystalBlockID = i;
	}

	//custom method might be fucked!!
	private int findValidBlock(World world, int x, int y, int z){
		for (int i = y; i > 0; i--){
			if (checkBlock(world, x, i, z)) {
				System.out.println("found a tile!!");
				return i;
			}
		}
		System.out.println("dint found a tile!!");
		return -999;
	}
	private boolean checkBlock(World world, int x, int y, int z){
		return (world.isAirBlock(x, y, z) && ((BlockCrystal) Block.blocksList[this.crystalBlockID]).canBlockStay(world, x, y, z));
	}
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		int i = findValidBlock(world, x, y, z);
		if (i == -999){
			return false;
		}
		System.out.println("blight upon my family fgor 1000 generations");
		world.setBlock(x, i, z, this.crystalBlockID);
		return true;
	}
}
