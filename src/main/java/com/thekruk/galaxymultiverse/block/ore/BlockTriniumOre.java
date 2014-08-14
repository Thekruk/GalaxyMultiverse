package com.thekruk.galaxymultiverse.block.ore;

import com.thekruk.galaxymultiverse.block.BlockGAMU;
import net.minecraft.block.material.Material;

public class BlockTriniumOre extends BlockGAMU
{
    public BlockTriniumOre()
    {
        super(Material.rock);
        this.setBlockName("triniumore");
        // this.setLightLevel(15);
        this.setHardness(6F);
        this.setResistance(5F);
        this.setHarvestLevel("pickaxe", 3);
        // this.setStepSound()
        // this.set*   Mange andre ting
    }
}
