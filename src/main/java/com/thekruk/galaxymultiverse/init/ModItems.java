package com.thekruk.galaxymultiverse.init;

import com.thekruk.galaxymultiverse.item.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemGAMU fodinaire = new ItemFodinaire();
    public static final ItemGAMU naquadah = new ItemNaquadah();
    public static final ItemGAMU naquadria = new ItemNaquadria();
    public static final ItemGAMU neutronium = new ItemNeutronium();
    public static final ItemGAMU olesian = new ItemOlesian();
    public static final ItemGAMU titanium = new ItemTitanium();
    public static final ItemGAMU trinium = new ItemTrinium();

    public static void init()
    {
        GameRegistry.registerItem(fodinaire, "fodinaire");
        GameRegistry.registerItem(naquadah, "naquadah");
        GameRegistry.registerItem(naquadria, "naquadria");
        GameRegistry.registerItem(neutronium, "neutronium");
        GameRegistry.registerItem(olesian, "olesian");
        GameRegistry.registerItem(titanium, "titanium");
        GameRegistry.registerItem(trinium, "trinium");
    }
}
