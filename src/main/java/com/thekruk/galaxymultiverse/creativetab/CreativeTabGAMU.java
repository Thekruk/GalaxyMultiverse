package com.thekruk.galaxymultiverse.creativetab;

import com.thekruk.galaxymultiverse.init.ModBlocks;
import com.thekruk.galaxymultiverse.init.ModItems;
import com.thekruk.galaxymultiverse.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabGAMU
{
    public static final CreativeTabs GAMU_TAB_BLOCKS = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "Blocks")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(ModBlocks.triniumore);
        }
    };

    public static final CreativeTabs GAMU_TAB_MACHINE = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "Machines")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(ModBlocks.triniumore);
        }
    };

    public static final CreativeTabs GAMU_TAB_TOOLS = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "Tools")
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.trinium;
        }
    };

    public static final CreativeTabs GAMU_TAB_MISC = new CreativeTabs(Reference.MOD_ID.toLowerCase() + "Misc")
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.trinium;
        }
    };
}
