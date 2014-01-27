package com.entropicdreams.darva;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.entropicdreams.darva.common.ModRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAllomancy extends CreativeTabs
{
    public CreativeTabAllomancy(int id, String mod_id)
    {
        super(id, mod_id);
    }
    @Override
    public String getTabLabel()
    {
    	return "Allomancy";
    }
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ModRegistry.itemVial, 1, 5);
	}
    @Override
    public int getTabIconItemIndex()
    {
        return 0;
    }
}