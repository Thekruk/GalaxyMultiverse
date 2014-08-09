package com.thekruk.galaxymultiverse.block;

import com.thekruk.galaxymultiverse.creativetab.CreativeTabGAMUBlocks;
import com.thekruk.galaxymultiverse.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockGAMU extends Block
{
    public BlockGAMU()
    {
        this(Material.rock);
    }

    public BlockGAMU(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabGAMUBlocks.GAMU_TAB_BLOCKS);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
        // tile.modid:blockname.name
    }

    @Override
    @SideOnly(Side.CLIENT)
    public  void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
