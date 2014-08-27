package com.thekruk.galaxymultiverse;

import com.thekruk.galaxymultiverse.handler.ConfigurationHandler;
import com.thekruk.galaxymultiverse.init.ModBlocks;
import com.thekruk.galaxymultiverse.init.ModItems;
import com.thekruk.galaxymultiverse.init.Recipes;
import com.thekruk.galaxymultiverse.proxy.IProxy;
import com.thekruk.galaxymultiverse.reference.Reference;
import com.thekruk.galaxymultiverse.solsystem.omnis.frigus.FrigusWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.furor.FurorWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.glacialis.GlacialisWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.ignotus.IgnotusWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.infervesco.InfervescoWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.medius.MediusTeleportType;
import com.thekruk.galaxymultiverse.solsystem.omnis.medius.MediusWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.medius.fultus.FultusWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.orbis.OrbisWorldProvider;
import com.thekruk.galaxymultiverse.solsystem.omnis.siccus.SiccusWorldProvider;
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

import java.util.HashMap;
import java.util.Map;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class GalaxyMultiverse
{
    public static SolarSystem solarSystemOmnis;
    public static Planet planetFuror;
    public static Planet planetInfervesco;
    public static Planet planetSiccus;
    public static Planet planetMedius;
    public static Moon moonFultus;
    public static Planet planetFrigus;
    public static Planet planetGlacialis;
    public static Planet planetOrbis;
    public static Planet planetIgnotus;

    @Mod.Instance(Reference.MOD_ID)
    public static GalaxyMultiverse instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();
        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Recipes.init();

        solarSystemOmnis = new SolarSystem("omnis", "milkyWay").setMapPosition(new Vector3(0.0F, 0.0F));
        Star starOmnis = (Star) new Star("omnis").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setTierRequired(-1);
        starOmnis.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
        solarSystemOmnis.setMainStar(starOmnis);

        planetFuror = (Planet) new Planet("furor").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(2.0F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.50F, 0.50F)).setRelativeOrbitTime(0.58F);
        planetFuror.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/furor.png"));
        planetFuror.setRelativeOrbitTime(100F).setTierRequired(3);
        planetFuror.setDimensionInfo(ConfigurationHandler.idDimensionFuror, FurorWorldProvider.class);
        planetFuror.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetInfervesco = (Planet) new Planet("infervesco").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(0.7F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F, 0.75F)).setRelativeOrbitTime(0.80F);
        planetInfervesco.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/infervesco.png"));
        planetInfervesco.setRelativeOrbitTime(100F).setTierRequired(3);
        planetInfervesco.setDimensionInfo(ConfigurationHandler.idDimensionInfervesco, InfervescoWorldProvider.class);
        planetInfervesco.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetSiccus = (Planet) new Planet("siccus").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(0.85F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(1.08F);
        planetSiccus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/siccus.png"));
        planetSiccus.setRelativeOrbitTime(100F).setTierRequired(3);
        planetSiccus.setDimensionInfo(ConfigurationHandler.idDimensionSiccus, SiccusWorldProvider.class);
        planetSiccus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetMedius = (Planet) new Planet("medius").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.0F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.25F, 1.25F)).setRelativeOrbitTime(1.48F);
        planetMedius.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/medius.png"));
        planetMedius.setRelativeOrbitTime(100F).setTierRequired(3);
        planetMedius.setDimensionInfo(ConfigurationHandler.idDimensionMedius, MediusWorldProvider.class);
        planetMedius.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        moonFultus = (Moon) new Moon("fultus").setParentPlanet(GalaxyMultiverse.planetMedius).setRelativeSize(0.0017F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8F, 8F));
        moonFultus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/fultus.png"));
        moonFultus.setRelativeOrbitTime(100F).setTierRequired(1);
        moonFultus.setDimensionInfo(ConfigurationHandler.idDimensionFultus, FultusWorldProvider.class);

        planetFrigus = (Planet) new Planet("frigus").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.2F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F)).setRelativeOrbitTime(1.88F);
        planetFrigus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/frigus.png"));
        planetFrigus.setRelativeOrbitTime(100F).setTierRequired(3);
        planetFrigus.setDimensionInfo(ConfigurationHandler.idDimensionFrigus, FrigusWorldProvider.class);
        planetFrigus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetGlacialis = (Planet) new Planet("glacialis").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.8F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F)).setRelativeOrbitTime(2.28F);
        planetGlacialis.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/glacialis.png"));
        planetGlacialis.setRelativeOrbitTime(100F).setTierRequired(3);
        planetGlacialis.setDimensionInfo(ConfigurationHandler.idDimensionGlacialis, GlacialisWorldProvider.class);
        planetGlacialis.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetOrbis = (Planet) new Planet("orbis").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.0F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(2.68F);
        planetOrbis.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/orbis.png"));
        planetOrbis.setRelativeOrbitTime(100F).setTierRequired(3);
        planetOrbis.setDimensionInfo(ConfigurationHandler.idDimensionOrbis, OrbisWorldProvider.class);
        planetOrbis.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetIgnotus = (Planet) new Planet("ignotus").setParentSolarSystem(GalaxyMultiverse.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.0F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.50F, 2.50F)).setRelativeOrbitTime(3.0F);
        planetIgnotus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/ignotus.png"));
        planetIgnotus.setRelativeOrbitTime(100F).setTierRequired(3);
        planetIgnotus.setDimensionInfo(ConfigurationHandler.idDimensionIgnotus, IgnotusWorldProvider.class);
        planetIgnotus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        GalaxyRegistry.registerSolarSystem(GalaxyMultiverse.solarSystemOmnis);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetFuror);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetInfervesco);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetSiccus);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetMedius);
        GalaxyRegistry.registerMoon(GalaxyMultiverse.moonFultus);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetFrigus);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetGlacialis);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetOrbis);
        GalaxyRegistry.registerPlanet(GalaxyMultiverse.planetIgnotus);
        GalacticraftRegistry.registerTeleportType(FurorWorldProvider.class, new FurorWorldProvider());
        GalacticraftRegistry.registerTeleportType(InfervescoWorldProvider.class, new InfervescoWorldProvider());
        GalacticraftRegistry.registerTeleportType(SiccusWorldProvider.class, new SiccusWorldProvider());
        GalacticraftRegistry.registerTeleportType(MediusWorldProvider.class, new MediusTeleportType());
        GalacticraftRegistry.registerTeleportType(FultusWorldProvider.class, new FultusWorldProvider());
        GalacticraftRegistry.registerTeleportType(FrigusWorldProvider.class, new FrigusWorldProvider());
        GalacticraftRegistry.registerTeleportType(GlacialisWorldProvider.class, new GlacialisWorldProvider());
        GalacticraftRegistry.registerTeleportType(OrbisWorldProvider.class, new OrbisWorldProvider());
        GalacticraftRegistry.registerTeleportType(IgnotusWorldProvider.class, new IgnotusWorldProvider());

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
