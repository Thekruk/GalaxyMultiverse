package com.thekruk.galaxymultiverse.handler;

import com.thekruk.galaxymultiverse.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            // Resync configs
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an examlpe configuration value");
        int mercuryID = configuration.getInt("mercury ID", Configuration.CATEGORY_GENERAL, -40, -90, -40, "Mercury Planet ID");
        int venusID = configuration.getInt("venus ID", Configuration.CATEGORY_GENERAL, -41, -90, -40, "Venus Planet ID");

        int furorID = configuration.getInt("furor ID", Configuration.CATEGORY_GENERAL, -50, -90, -40, "Furor Planet ID");
        int infervescoID = configuration.getInt("infervesco ID", Configuration.CATEGORY_GENERAL, -51, -90, -40, "Infervesco Planet ID");
        int siccusID = configuration.getInt("siccus ID", Configuration.CATEGORY_GENERAL, -52, -90, -40, "Siccus Planet ID");
        int mediusID = configuration.getInt("medius ID", Configuration.CATEGORY_GENERAL, -53, -90, -40, "Medius Planet ID");
        int fultusID = configuration.getInt("fultus ID", Configuration.CATEGORY_GENERAL, -54, -90, -40, "Fultus Planet ID");
        int frigusID = configuration.getInt("frigus ID", Configuration.CATEGORY_GENERAL, -55, -90, -40, "Frigus Planet ID");
        int glacialisID = configuration.getInt("glacialis ID", Configuration.CATEGORY_GENERAL, -56, -90, -40, "Glacialis Planet ID");
        int orbisID = configuration.getInt("orbis ID", Configuration.CATEGORY_GENERAL, -57, -90, -40, "Orbis Planet ID");
        int ignotusID = configuration.getInt("ignotus ID", Configuration.CATEGORY_GENERAL, -58, -90, -40, "Ignotus Planet ID");

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
}
