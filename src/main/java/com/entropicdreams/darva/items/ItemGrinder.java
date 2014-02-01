package com.entropicdreams.darva.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.entropicdreams.darva.common.Registry;

public class ItemGrinder extends Item {

	public ItemGrinder(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("allomancy:Grinder");
		this.setCreativeTab(Registry.tabsAllomancy);
		this.setMaxDamage(63);
		this.maxStackSize = 1;
	}

	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasContainerItem() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ItemStack getContainerItemStack(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return new ItemStack(Registry.itemAllomancyGrinder, 1,
				this.getDamage(itemStack) + 1);
	}

}
