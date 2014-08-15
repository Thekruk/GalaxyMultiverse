package com.thekruk.galaxymultiverse;

import com.thekruk.galaxymultiverse.handler.ConfigurationHandler;
import com.thekruk.galaxymultiverse.init.ModBlocks;
import com.thekruk.galaxymultiverse.init.ModItems;
import com.thekruk.galaxymultiverse.init.Recipes;
import com.thekruk.galaxymultiverse.proxy.IProxy;
import com.thekruk.galaxymultiverse.reference.Reference;
import com.thekruk.galaxymultiverse.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class GalaxyMultiverse
{
    @Mod.Instance(Reference.MOD_ID)
    public static GalaxyMultiverse instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre Initialization Complete");

        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Recipes.init();
        LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Complete");

        // for (String oreName : OreDictionary.getOreNames())
        // {
        //     LogHelper.info(oreName);
        // }
    }
}
