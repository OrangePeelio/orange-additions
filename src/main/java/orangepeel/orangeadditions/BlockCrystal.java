package orangepeel.orangeadditions;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockFlower;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

public class BlockCrystal extends Block {


	protected boolean canThisPlantGrowOnThisBlockID(int i) {
		return Block.solid[i];
	}
	public boolean canBlockStay(World world, int x, int y, int z) {
		if (this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z))){
			return true;
		}
		if (this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y + 1, z))){
			return true;
		}
		if (this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y, z - 1))){
			return true;
		}
		if (this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y, z +1))){
			return true;
		}
		if (this.canThisPlantGrowOnThisBlockID(world.getBlockId(x - 1, y, z))){
			return true;
		}
		return this.canThisPlantGrowOnThisBlockID(world.getBlockId(x + 1, y, z));
	}

	public BlockCrystal(String key, int id) {
		super(key, id, new Material(MaterialColor.stone));
		float f = 0.2F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
	}
	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		if (world.isBlockNormalCube(x - 1, y, z)) {
			return true;
		} else if (world.isBlockNormalCube(x + 1, y, z)) {
			return true;
		} else if (world.isBlockNormalCube(x, y, z - 1)) {
			return true;
		} else if (world.isBlockNormalCube(x, y + 1, z )) {
			return true;
		}
		else if (world.isBlockNormalCube(x, y, z + 1)){
			return true;
		}
		else {
			 return world.isBlockNormalCube(x, y - 1, z)|| world.canPlaceOnSurfaceOfBlock(x, y - 1, z);
		}
	}
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		int l = side.getId();
		int i1 = world.getBlockMetadata(x, y, z);
		if (l == 1 && world.isBlockNormalCube(x, y + 1, z)) {
			i1 = 6;
		}
		if (l == 1 && world.isBlockNormalCube(x, y - 1, z)) {
			i1 = 5;
		}

		if (l == 2 && world.isBlockNormalCube(x, y, z + 1)) {
			i1 = 4;
		}

		if (l == 3 && world.isBlockNormalCube(x, y, z - 1)) {
			i1 = 3;
		}

		if (l == 4 && world.isBlockNormalCube(x + 1, y, z)) {
			i1 = 2;
		}

		if (l == 5 && world.isBlockNormalCube(x - 1, y, z)) {
			i1 = 1;
		}

		world.setBlockMetadataWithNotify(x, y, z, i1);
	}
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (this.dropCrystalIfCantStay(world, x, y, z)) {
			int i1 = world.getBlockMetadata(x, y, z);
			boolean flag = false;
			if (!world.isBlockNormalCube(x - 1, y, z) && i1 == 1) {
				flag = true;
			}

			if (!world.isBlockNormalCube(x + 1, y, z) && i1 == 2) {
				flag = true;
			}

			if (!world.isBlockNormalCube(x, y, z - 1) && i1 == 3) {
				flag = true;
			}

			if (!world.isBlockNormalCube(x, y, z + 1) && i1 == 4) {
				flag = true;
			}

			if (!world.isBlockNormalCube(x, y - 1, z) && i1 == 5) {
				flag = true;
			}
			if (!world.isBlockNormalCube(x, y + 1, z) && i1 == 6) {
				flag = true;
			}

			if (flag) {
				this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, i1, (TileEntity) null);
				world.setBlockWithNotify(x, y, z, 0);
			}
		}
	}
	public void onBlockAdded(World world, int i, int j, int k) {
		if (world.isBlockNormalCube(i - 1, j, k)) {
			world.setBlockMetadataWithNotify(i, j, k, 1);
		} else if (world.isBlockNormalCube(i + 1, j, k)) {
			world.setBlockMetadataWithNotify(i, j, k, 2);
		} else if (world.isBlockNormalCube(i, j, k - 1)) {
			world.setBlockMetadataWithNotify(i, j, k, 3);
		} else if (world.isBlockNormalCube(i, j, k + 1)) {
			world.setBlockMetadataWithNotify(i, j, k, 4);
		} else if (world.isBlockNormalCube(i, j - 1, k)) {
			world.setBlockMetadataWithNotify(i, j, k, 5);
		} else if (world.isBlockNormalCube(i, j + 1, k)) {
			world.setBlockMetadataWithNotify(i, j, k, 6);
		}
		System.out.print("droponBlockAdded");
		this.dropCrystalIfCantStay(world, i, j, k);
	}
	private boolean dropCrystalIfCantStay(World world, int i, int j, int k) {
		if (!this.canPlaceBlockAt(world, i, j, k)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, i, j, k, world.getBlockMetadata(i, j, k), (TileEntity)null);
			world.setBlockWithNotify(i, j, k, 0);
			System.out.println("dropppppp");
			return false;
		} else {
			return true;
		}
	}

}
