package com.thekruk.galaxymultiverse;

import com.thekruk.galaxymultiverse.handler.ConfigurationHandler;
import com.thekruk.galaxymultiverse.init.ModBlocks;
import com.thekruk.galaxymultiverse.init.ModItems;
import com.thekruk.galaxymultiverse.init.Recipes;
import com.thekruk.galaxymultiverse.proxy.IProxy;
import com.thekruk.galaxymultiverse.reference.Reference;
import com.thekruk.galaxymultiverse.solsystem.omnis.medius.MediusTeleportType;
import com.thekruk.galaxymultiverse.solsystem.omnis.medius.MediusWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.medius.fultus.FultusWorldProvider;
import com.thekruk.galaxymultiverse.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.*;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.util.ResourceLocation;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class GalaxyMultiverse
{
    public static SolarSystem solarSystemOmnis;
    public static Planet planetMedius;
    public static Moon moonFultus;


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


        solarSystemOmnis = new SolarSystem("omnis", "milkyWay").setMapPosition(new Vector3(0.0F, 0.0F));
        Star starOmnis = (Star) new Star("omnis").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setTierRequired(-1);
        starOmnis.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
        solarSystemOmnis.setMainStar(starOmnis);

        planetMedius = (Planet) new Planet("medius").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.25F, 1.25F)).setRelativeOrbitTime(1.8811610076670317634173055859803F);
        planetMedius.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/medius.png"));
        planetMedius.setRelativeOrbitTime(100F).setTierRequired(3);
        planetMedius.setDimensionInfo(ConfigurationHandler.idDimensionMedius, MediusWorldProvider.class);
        planetMedius.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        moonFultus = (Moon) new Moon("fultus").setParentPlanet(GalacticraftCore.planetVenus).setRelativeSize(0.0017F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8F, 8F));
        moonFultus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/fultus.png"));
        moonFultus.setRelativeOrbitTime(100F).setTierRequired(1);
        moonFultus.setDimensionInfo(ConfigurationHandler.idDimensionFultus, FultusWorldProvider.class);

        GalaxyRegistry.registerSolarSystem(GalaxyMultiverse.solarSystemOmnis);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetMedius);
        GalaxyRegistry.registerMoon(GalaxyMultiverse.moonFultus);
        GalacticraftRegistry.registerTeleportType(MediusWorldProvider.class, new MediusTeleportType());
        GalacticraftRegistry.registerTeleportType(FultusWorldProvider.class, new FultusWorldProvider());
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
