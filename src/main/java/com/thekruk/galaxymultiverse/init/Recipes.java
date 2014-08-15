package com.thekruk.galaxymultiverse.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void init()
    {
        // GameRegistry.addRecipe(new ItemStack(ModItems.trinium), " s ", "sss", " s ", 's', new ItemStack(Items.stick));
        // GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.triniumore), new ItemStack(ModItems.trinium), new ItemStack(ModItems.trinium));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.trinium), " s ", "sss", " s ", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.triniumore), "stickWood", new ItemStack(ModItems.trinium)));
    }
}
