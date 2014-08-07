package com.thekruk.galaxymultiverse.init;

import com.thekruk.galaxymultiverse.item.ItemGAMU;
import com.thekruk.galaxymultiverse.item.ItemTrinium;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemGAMU trinium = new ItemTrinium();

    public static void init()
    {
        GameRegistry.registerItem(trinium, "trinium");
    }
}
