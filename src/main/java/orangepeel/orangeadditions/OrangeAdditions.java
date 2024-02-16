package orangepeel.orangeadditions;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSound;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockMushroom;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.ItemArmor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.*;


public class OrangeAdditions implements ModInitializer {
    public static final String MOD_ID = "orangeadditions";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//armor
	public static final ArmorMaterial speedBoosterMaterial = ArmorHelper.createArmorMaterial(
		"testarmor",
		300,
		20,
		20,
		0,
		50
	);
	//item ting :3
	public static final Item brightitePowder = ItemHelper.createItem(OrangeAdditions.MOD_ID,
		new Item("brightitepowder", 20000),
		"brightitepowder",
		"brightitepowder.png");
	public static final Item blightiteShards = ItemHelper.createItem(OrangeAdditions.MOD_ID,
		new Item("blightiteshards", 20001),
		"blightiteshards",
		"blightiteshards.png");
	public static final Item prismariteSnow = ItemHelper.createItem(OrangeAdditions.MOD_ID,
		new Item("prismaritesnow", 20002),
		"prismaritesnow",
		"prismaritesnow.png");
	public static final Item pixieDust = ItemHelper.createItem(OrangeAdditions.MOD_ID,
		new Item("pixiedust", 20003),
		"pixiedust",
		"pixiedust.png");
	public static final Item artificialWing = ItemHelper.createItem(OrangeAdditions.MOD_ID,
		new Item("artificialwing", 20004),
		"artificialwing",
		"artificialwing.png");
	public static final ItemArmor speedBoosters = (ItemArmor) ItemHelper.createItem(OrangeAdditions.MOD_ID,
		new ItemArmor("speedboosters", 20005, speedBoosterMaterial, 2),
		"speedboosters",
		"speedboosters.png");


	//blocks
	public static final Block brightiteCrystal = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.stone", "random.glass", 1.0f, 1.0f))
		.setHardness (0.0f)
		.setResistance(0.0f)
		.setLuminance(9)
		.setTextures("brightite.png")
		.setBlockModel(new BlockModelRenderBlocks(1))
		.setTags(BlockTags.BROKEN_BY_FLUIDS)
		.build(new BlockCrystal("brightitecrystal", 10000));
	public static final Block blightiteCrystal = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.stone", "random.glass", 1.0f, 1.0f))
		.setHardness (0.0f)
		.setResistance(0.0f)
		.setTextures("blightite.png")
		.setBlockModel(new BlockModelRenderBlocks(1))
		.setTags(BlockTags.BROKEN_BY_FLUIDS)
		.build(new BlockCrystal("blightitecrystal", 10001));
	public static final Block prismariteFlake = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.stone", "random.glass", 1.0f, 1.0f))
		.setHardness (0.0f)
		.setResistance(0.0f)
		.setLuminance(4)
		.setTextures("prismarite.png")
		.setBlockModel(new BlockModelRenderBlocks(1))
		.setTags(BlockTags.BROKEN_BY_FLUIDS)
		.build(new BlockCrystal("prismariteflake", 10002));
	public static final Block whiteMushroom = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.grass", "step.grass", 1.0f, 1.0f))
		.setHardness(0.0f)
		.setResistance(0.0f)
		.setTextures("whitemushroom.png")
		.setBlockModel(new BlockModelRenderBlocks(1))
		.setTags(BlockTags.SHEARS_DO_SILK_TOUCH, BlockTags.BROKEN_BY_FLUIDS)
		.build(new BlockMushroom("whitemushroom", 10003));
	public static final Block crimtane = new BlockBuilder(MOD_ID)
		.setBlockSound(new BlockSound("step.stone", "step.stone", 1, .6f))
		.setHardness(8f)
		.setResistance(110000f)
		.setTextures("crimtane.png")
		.setTags(BlockTags.MINEABLE_BY_PICKAXE)
		.build(new Block("crimtane", 10004, Material.stone));

	//recipies
	final static String[] recipeSpeedBoosters = {
		"AAA",
		"B B",
		"C C"
	};



    @Override
    public void onInitialize() {

		LOGGER.info("OrangeAdditions initialized.");
		//recipies?
		RecipeHelper.Crafting.createShapelessRecipe(new ItemStack(artificialWing, 1),  new Object[]{
			Item.leather,
			Item.featherChicken,
			pixieDust,
			pixieDust
		});
		RecipeHelper.Crafting.createRecipe(new ItemStack(speedBoosters, 1), new Object[]{
			recipeSpeedBoosters,
			'A', Item.ingotSteel,
			'B', blightiteShards,
			'C', artificialWing
		});
	}


}
