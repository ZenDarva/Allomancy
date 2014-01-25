package com.entropicdreams.darva.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.entropicdreams.darva.CreativeTabAllomancy;
import com.entropicdreams.darva.items.ItemGrinder;
import com.entropicdreams.darva.items.ItemMistcloak;
import com.entropicdreams.darva.items.ItemVial;
import com.entropicdreams.darva.util.AllomancyConfig;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModRegistry {
	public static void ModContent() {
		initItems();
		initBlocks();
		setupItems();
		setupBlocks();
		setupRecipies();
		setupKeybinds();
	}

	public static void setupRecipies() {

		GameRegistry.addSmelting(oreTin.blockID,
				new ItemStack(itemTinIngot, 1), 5);
		GameRegistry.addSmelting(oreCopper.blockID, new ItemStack(
				itemCopperIngot, 1), 5);
		GameRegistry.addSmelting(oreLead.blockID, new ItemStack(itemLeadIngot,
				1), 5);
		GameRegistry.addSmelting(oreZinc.blockID, new ItemStack(itemZincIngot,
				1), 5);

		GameRegistry.addShapelessRecipe(new ItemStack(itemTinFlakes, 1),
				new ItemStack(itemTinIngot), new ItemStack(itemGrinder, 1,
						OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(itemLeadFlakes, 1),
				new ItemStack(itemLeadIngot), new ItemStack(itemGrinder, 1,
						OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(itemCopperFlakes, 1),
				new ItemStack(itemCopperIngot), new ItemStack(itemGrinder, 1,
						OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(itemZincFlakes, 1),
				new ItemStack(itemZincIngot), new ItemStack(itemGrinder, 1,
						OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(itemIronFlakes, 1),
				new ItemStack(Item.ingotIron), new ItemStack(itemGrinder, 1,
						OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(itemSteelFlakes, 1),
				new ItemStack(itemIronFlakes), new ItemStack(Item.coal));
		GameRegistry.addShapelessRecipe(new ItemStack(itemBrassFlakes, 1),
				new ItemStack(itemZincFlakes), new ItemStack(itemCopperFlakes));
		GameRegistry.addShapelessRecipe(new ItemStack(itemPewterFlakes, 1),
				new ItemStack(itemPewterFlakes), new ItemStack(itemLeadFlakes));
		GameRegistry.addShapelessRecipe(new ItemStack(itemBronzeFlakes, 1),
				new ItemStack(itemCopperFlakes), new ItemStack(itemTinFlakes));

		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 1),
				new ItemStack(itemCopperFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 2),
				new ItemStack(itemIronFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 3),
				new ItemStack(itemTinFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 4),
				new ItemStack(itemZincFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 5),
				new ItemStack(itemBrassFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 6),
				new ItemStack(itemSteelFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 7),
				new ItemStack(itemPewterFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));
		GameRegistry.addShapelessRecipe(new ItemStack(itemVial, 1, 8),
				new ItemStack(itemBronzeFlakes), new ItemStack(itemVial, 1, 0),
				new ItemStack(Item.bucketWater));

		GameRegistry.addRecipe(new ItemStack(Mistcloak, 1), new Object[] {
				"W W", "WWW", "WWW", 'W', new ItemStack(Block.cloth, 1, 7) });
		GameRegistry.addRecipe(new ShapedOreRecipe(
				new ItemStack(itemVial, 1, 0), " x ", "y y", " y ", 'x',
				"slabWood", 'y', Block.glass));

	}
	public static CreativeTabs tabsAllomancy =
	        new CreativeTabAllomancy(CreativeTabs.getNextID(), "allomancy");
	
	public static void initBlocks() {
		oreTin = new Block(AllomancyConfig.oreTin, Material.rock)
				.setHardness(.5f).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(CreativeTabs.tabBlock)
				.setTextureName("allomancy:tinore")
				.setUnlocalizedName("allomancy:tinore");

		oreLead = new Block(AllomancyConfig.oreLead, Material.rock)
				.setHardness(.5f).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(CreativeTabs.tabBlock)
				.setTextureName("allomancy:leadore")
				.setUnlocalizedName("allomancy:leadore");

		oreCopper = new Block(AllomancyConfig.oreCopper, Material.rock)
				.setHardness(.5f).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(CreativeTabs.tabBlock)
				.setTextureName("allomancy:copperore")
				.setUnlocalizedName("allomancy:copperore");

		oreZinc = new Block(AllomancyConfig.oreZinc, Material.rock)
				.setHardness(.5f).setStepSound(Block.soundStoneFootstep)
				.setCreativeTab(CreativeTabs.tabBlock)
				.setTextureName("allomancy:zincore")
				.setUnlocalizedName("allomancy:zincore");

	}

	public static void setupBlocks() {
		GameRegistry.registerBlock(oreTin, "allomancy:tinore");
		LanguageRegistry.addName(oreTin, "Tin Ore");
		MinecraftForge.setBlockHarvestLevel(oreTin, "pick", 1);

		GameRegistry.registerBlock(oreLead, "allomancy:leadore");
		LanguageRegistry.addName(oreLead, "Lead Ore");
		MinecraftForge.setBlockHarvestLevel(oreLead, "pick", 1);

		GameRegistry.registerBlock(oreCopper, "allomancy:copperore");
		LanguageRegistry.addName(oreCopper, "Copper Ore");
		MinecraftForge.setBlockHarvestLevel(oreCopper, "pick", 1);

		GameRegistry.registerBlock(oreZinc, "allomancy:zincore");
		LanguageRegistry.addName(oreZinc, "Zinc Ore");
		MinecraftForge.setBlockHarvestLevel(oreZinc, "pick", 1);

	}

	public static EnumArmorMaterial WoolArmor = EnumHelper.addArmorMaterial(
			"Wool", 5, new int[] { 0, 4, 0, 0 }, 15);

	public static void initItems() {
		itemGrinder = new ItemGrinder(AllomancyConfig.itemGrinder);

		itemTinIngot = new Item(AllomancyConfig.itemTinIngot)
				.setUnlocalizedName("allomancy:tiningot")
				.setCreativeTab(ModRegistry.tabsAllomancy).setMaxDamage(0);
		itemTinFlakes = new Item(AllomancyConfig.itemTinFlakes)
				.setUnlocalizedName("allomancy:tinflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemLeadIngot = new Item(AllomancyConfig.itemLeadIngot)
				.setUnlocalizedName("allomancy:leadingot")
				.setCreativeTab(ModRegistry.tabsAllomancy).setMaxDamage(0);
		itemLeadFlakes = new Item(AllomancyConfig.itemLeadFlakes)
				.setUnlocalizedName("allomancy:leadflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemCopperIngot = new Item(AllomancyConfig.itemCopperIngot)
				.setUnlocalizedName("allomancy:copperingot")
				.setCreativeTab(ModRegistry.tabsAllomancy).setMaxDamage(0);
		itemCopperFlakes = new Item(AllomancyConfig.itemCopperFlakes)
				.setUnlocalizedName("allomancy:copperflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemZincIngot = new Item(AllomancyConfig.itemZincIngot)
				.setUnlocalizedName("allomancy:zincingot")
				.setCreativeTab(ModRegistry.tabsAllomancy).setMaxDamage(0);
		itemZincFlakes = new Item(AllomancyConfig.itemZincFlakes)
				.setUnlocalizedName("allomancy:zincflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemIronFlakes = new Item(AllomancyConfig.itemIronFlakes)
				.setUnlocalizedName("allomancy:ironflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemSteelFlakes = new Item(AllomancyConfig.itemSteelFlakes)
				.setUnlocalizedName("allomancy:steelflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemBrassFlakes = new Item(AllomancyConfig.itemBrassFlakes)
				.setUnlocalizedName("allomancy:brassflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemPewterFlakes = new Item(AllomancyConfig.itemPewterFlakes)
				.setUnlocalizedName("allomancy:pewterflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);
		itemBronzeFlakes = new Item(AllomancyConfig.itemBronzeFlakes)
				.setUnlocalizedName("allomancy:bronzeflakes").setCreativeTab(
						ModRegistry.tabsAllomancy);

		Mistcloak = new ItemMistcloak(AllomancyConfig.Mistcloak, WoolArmor, 5,
				1).setUnlocalizedName("allomancy:mistcloak").setCreativeTab(
						ModRegistry.tabsAllomancy);

		itemVial = new ItemVial(AllomancyConfig.itemVial);
	}

	public static void setupItems() {
		GameRegistry.registerItem(itemGrinder, "allomancy:Grinder");
		LanguageRegistry.addName(itemGrinder, "Hand Grinder");
		itemGrinder.setTextureName("allomancy:handgrinder");

		GameRegistry.registerItem(itemTinIngot, "allomancy:tiningot");
		LanguageRegistry.addName(itemTinIngot, "Tin Ingot");
		itemTinIngot.setTextureName("allomancy:tiningot");

		GameRegistry.registerItem(itemTinFlakes, "allomancy:tinflakes");
		LanguageRegistry.addName(itemTinFlakes, "Tin Flakes");
		itemTinFlakes.setTextureName("allomancy:tinflakes");

		GameRegistry.registerItem(itemLeadIngot, "allomancy:leadingot");
		LanguageRegistry.addName(itemLeadIngot, "Lead Ingot");
		itemLeadIngot.setTextureName("allomancy:leadingot");

		GameRegistry.registerItem(itemLeadFlakes, "allomancy:leadflakes");
		LanguageRegistry.addName(itemLeadFlakes, "Lead Flakes");
		itemLeadFlakes.setTextureName("allomancy:leadflakes");

		GameRegistry.registerItem(itemCopperIngot, "allomancy:copperingot");
		LanguageRegistry.addName(itemCopperIngot, "Copper Ingot");
		itemCopperIngot.setTextureName("allomancy:copperingot");

		GameRegistry.registerItem(itemCopperFlakes, "allomancy:copperflakes");
		LanguageRegistry.addName(itemCopperFlakes, "Copper Flakes");
		itemCopperFlakes.setTextureName("allomancy:copperflakes");

		GameRegistry.registerItem(itemZincIngot, "allomancy:zincingot");
		LanguageRegistry.addName(itemZincIngot, "Zinc Ingot");
		itemZincIngot.setTextureName("allomancy:zincingot");

		GameRegistry.registerItem(itemZincFlakes, "allomancy:zincflakes");
		LanguageRegistry.addName(itemZincFlakes, "Zinc Flakes");
		itemZincFlakes.setTextureName("allomancy:zincflakes");

		GameRegistry.registerItem(itemIronFlakes, "allomancy:ironflakes");
		LanguageRegistry.addName(itemIronFlakes, "Iron Flakes");
		itemIronFlakes.setTextureName("allomancy:ironflakes");

		GameRegistry.registerItem(itemSteelFlakes, "allomancy:steelflakes");
		LanguageRegistry.addName(itemSteelFlakes, "Steel Flakes");
		itemSteelFlakes.setTextureName("allomancy:steelflakes");

		GameRegistry.registerItem(itemBrassFlakes, "allomancy:brassflakes");
		LanguageRegistry.addName(itemBrassFlakes, "Brass Flakes");
		itemBrassFlakes.setTextureName("allomancy:brassflakes");

		GameRegistry.registerItem(itemPewterFlakes, "allomancy:pewterflakes");
		LanguageRegistry.addName(itemPewterFlakes, "Pewter Flakes");
		itemPewterFlakes.setTextureName("allomancy:pewterflakes");

		GameRegistry.registerItem(itemBronzeFlakes, "allomancy:bronzeflakes");
		LanguageRegistry.addName(itemBronzeFlakes, "Bronze Flakes");
		itemBronzeFlakes.setTextureName("allomancy:bronzeflakes");

		GameRegistry.registerItem(Mistcloak, "allomancy:mistcloak");
		LanguageRegistry.addName(Mistcloak, "Mistcloak");
		Mistcloak.setTextureName("allomancy:mistcloak");

		LanguageRegistry.instance().addStringLocalization("itemGroup.Allomancy", "Allomancy");
		
		RenderingRegistry.addNewArmourRendererPrefix("Mistcloak");

		ItemStack item;

		for (int i = 0; i < ItemVial.localName.length; i++) {
			ItemStack Item;
			Item = new ItemStack(itemVial, 1, i);
			LanguageRegistry.addName(Item, ItemVial.localName[i]);
		}
	}

	public static void setupKeybinds() {

	}

	public static ItemGrinder itemGrinder;
	public static Item itemTinIngot;
	public static Item itemTinFlakes;
	public static Item itemLeadIngot;
	public static Item itemLeadFlakes;
	public static Item itemCopperIngot;
	public static Item itemCopperFlakes;
	public static Item itemZincIngot;
	public static Item itemZincFlakes;
	public static Item itemBrassFlakes;
	public static Item itemSteelFlakes;
	public static Item itemPewterFlakes;
	public static Item itemIronFlakes;
	public static Item itemBronzeFlakes;
	public static Item Mistcloak;
	public static Block oreTin;
	public static Block oreLead;
	public static Block oreCopper;
	public static Block oreZinc;
	public static ItemVial itemVial;
}
