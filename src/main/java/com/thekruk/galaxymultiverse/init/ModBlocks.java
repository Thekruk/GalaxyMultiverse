package com.thekruk.galaxymultiverse.init;

import com.thekruk.galaxymultiverse.block.BlockGAMU;
import com.thekruk.galaxymultiverse.block.BlockTriniumOre;
import com.thekruk.galaxymultiverse.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockGAMU triniumore = new BlockTriniumOre();

    public static void init()
    {
        GameRegistry.registerBlock(triniumore, "triniumore");
    }
}
