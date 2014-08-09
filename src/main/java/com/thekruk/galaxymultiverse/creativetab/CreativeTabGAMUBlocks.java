package com.thekruk.galaxymultiverse.creativetab;

import com.thekruk.galaxymultiverse.init.ModItems;
import com.thekruk.galaxymultiverse.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabGAMUBlocks
{
    public static final CreativeTabs GAMU_TAB_BLOCKS = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.trinium;
        }

        @Override
        public  String getTranslatedTabLabel()
        {
            return "Galaxy Multiverse Blocks";
        }
    };
}
