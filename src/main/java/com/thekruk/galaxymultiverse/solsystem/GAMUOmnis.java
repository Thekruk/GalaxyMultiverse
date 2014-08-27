package com.thekruk.galaxymultiverse.solsystem;

import com.thekruk.galaxymultiverse.GalaxyMultiverse;
import com.thekruk.galaxymultiverse.handler.ConfigurationHandler;
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
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.Side;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.*;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;

public class GAMUOmnis implements IPlanetsModule
{
    public static SolarSystem solarSystemOmnis;
    //public static Planet planetFuror;
    public static Planet planetInfervesco;
    public static Planet planetSiccus;
    public static Planet planetMedius;
    public static Moon moonFultus;
    public static Planet planetFrigus;
    public static Planet planetGlacialis;
    public static Planet planetOrbis;
    public static Planet planetIgnotus;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        solarSystemOmnis = new SolarSystem("omnis", "milkyWay").setMapPosition(new Vector3(0.0F, 0.0F));
        Star starOmnis = (Star) new Star("omnis").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setTierRequired(-1);
        starOmnis.setBodyIcon(new ResourceLocation(GalacticraftCore.ASSET_PREFIX, "textures/gui/celestialbodies/sun.png"));
        solarSystemOmnis.setMainStar(starOmnis);

        //planetFuror = (Planet) new Planet("furor").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(0.5319F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.50F, 0.50F)).setRelativeOrbitTime(0.24F);
        //planetFuror.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/furor.png"));
        //planetFuror.setTierRequired(3);
        //planetFuror.setDimensionInfo(ConfigurationHandler.idDimensionFuror, FurorWorldProvider.class);
        //planetFuror.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetInfervesco = (Planet) new Planet("infervesco").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(0.7F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(0.75F, 0.75F)).setRelativeOrbitTime(0.80F);
        planetInfervesco.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/infervesco.png"));
        planetInfervesco.setTierRequired(3);
        planetInfervesco.setDimensionInfo(ConfigurationHandler.idDimensionInfervesco, InfervescoWorldProvider.class);
        planetInfervesco.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetSiccus = (Planet) new Planet("siccus").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(0.85F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.0F, 1.0F)).setRelativeOrbitTime(1.08F);
        planetSiccus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/siccus.png"));
        planetSiccus.setTierRequired(3);
        planetSiccus.setDimensionInfo(ConfigurationHandler.idDimensionSiccus, SiccusWorldProvider.class);
        planetSiccus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetMedius = (Planet) new Planet("medius").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.0F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.25F, 1.25F)).setRelativeOrbitTime(1.48F);
        planetMedius.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/medius.png"));
        planetMedius.setTierRequired(3);
        planetMedius.setDimensionInfo(ConfigurationHandler.idDimensionMedius, MediusWorldProvider.class);
        planetMedius.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        moonFultus = (Moon) new Moon("fultus").setParentPlanet(GAMUOmnis.planetMedius).setRelativeSize(0.0017F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(8F, 8F));
        moonFultus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/fultus.png"));
        moonFultus.setTierRequired(1);
        moonFultus.setDimensionInfo(ConfigurationHandler.idDimensionFultus, FultusWorldProvider.class);

        planetFrigus = (Planet) new Planet("frigus").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.2F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.5F, 1.5F)).setRelativeOrbitTime(1.88F);
        planetFrigus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/frigus.png"));
        planetFrigus.setTierRequired(3);
        planetFrigus.setDimensionInfo(ConfigurationHandler.idDimensionFrigus, FrigusWorldProvider.class);
        planetFrigus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetGlacialis = (Planet) new Planet("glacialis").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.8F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(1.75F, 1.75F)).setRelativeOrbitTime(2.28F);
        planetGlacialis.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/glacialis.png"));
        planetGlacialis.setTierRequired(3);
        planetGlacialis.setDimensionInfo(ConfigurationHandler.idDimensionGlacialis, GlacialisWorldProvider.class);
        planetGlacialis.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetOrbis = (Planet) new Planet("orbis").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.0F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.0F, 2.0F)).setRelativeOrbitTime(2.68F);
        planetOrbis.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/orbis.png"));
        planetOrbis.setTierRequired(3);
        planetOrbis.setDimensionInfo(ConfigurationHandler.idDimensionOrbis, OrbisWorldProvider.class);
        planetOrbis.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        planetIgnotus = (Planet) new Planet("ignotus").setParentSolarSystem(GAMUOmnis.solarSystemOmnis).setRingColorRGB(0.67F, 0.1F, 0.1F).setPhaseShift(0.1667F).setRelativeSize(1.0F).setRelativeDistanceFromCenter(new CelestialBody.ScalableDistance(2.50F, 2.50F)).setRelativeOrbitTime(3.0F);
        planetIgnotus.setBodyIcon(new ResourceLocation(Reference.ASSET_PREFIX, "textures/gui/celestialbodies/ignotus.png"));
        planetIgnotus.setTierRequired(3);
        planetIgnotus.setDimensionInfo(ConfigurationHandler.idDimensionIgnotus, IgnotusWorldProvider.class);
        planetIgnotus.atmosphereComponent(IAtmosphericGas.CO2).atmosphereComponent(IAtmosphericGas.ARGON).atmosphereComponent(IAtmosphericGas.NITROGEN);

        GalaxyRegistry.registerSolarSystem(GAMUOmnis.solarSystemOmnis);
        //GalaxyRegistry.registerPlanet(GAMUOmnis.planetFuror);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetInfervesco);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetSiccus);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetMedius);
        GalaxyRegistry.registerMoon(GAMUOmnis.moonFultus);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetFrigus);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetGlacialis);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetOrbis);
        GalaxyRegistry.registerPlanet(GAMUOmnis.planetIgnotus);
        //GalacticraftRegistry.registerTeleportType(FurorWorldProvider.class, new FurorWorldProvider());
        GalacticraftRegistry.registerTeleportType(InfervescoWorldProvider.class, new InfervescoWorldProvider());
        GalacticraftRegistry.registerTeleportType(SiccusWorldProvider.class, new SiccusWorldProvider());
        GalacticraftRegistry.registerTeleportType(MediusWorldProvider.class, new MediusTeleportType());
        GalacticraftRegistry.registerTeleportType(FultusWorldProvider.class, new FultusWorldProvider());
        GalacticraftRegistry.registerTeleportType(FrigusWorldProvider.class, new FrigusWorldProvider());
        GalacticraftRegistry.registerTeleportType(GlacialisWorldProvider.class, new GlacialisWorldProvider());
        GalacticraftRegistry.registerTeleportType(OrbisWorldProvider.class, new OrbisWorldProvider());
        GalacticraftRegistry.registerTeleportType(IgnotusWorldProvider.class, new IgnotusWorldProvider());
        //GalacticraftRegistry.registerRocketGui(MediusWorldProvider.class, new ResourceLocation(GalaxyMultiverse.ASSET_PREFIX, "textures/gui/mediusRocketGui.png"));

        LogHelper.info("Initialization Omnis Complete");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
    }

    @Override
    public void serverStarting(FMLServerStartingEvent event)
    {
    }

    @Override
    public void serverInit(FMLServerStartedEvent event)
    {
    }

    @Override
    public void getGuiIDs(List<Integer> idList)
    {
    }
    @Override
    public Object getGuiElement(Side side, int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }
}
