package com.thekruk.galaxymultiverse.solsystem.omnis.frigus;

import com.thekruk.galaxymultiverse.GalaxyMultiverse;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IExitHeight;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import java.util.Random;

public class FrigusWorldProvider extends WorldProviderSpace implements IExitHeight, ISolarLevel, ITeleportType {

    @Override
    public boolean canSpaceshipTierPass(int tier) {
        return tier >= 3;
    }

    @Override
    public float getFallDamageModifier() {
        return 0.75F;
    }

    @Override
    public double getFuelUsageMultiplier() {
        return 0.8;
    }

    //Gravity is tricky. The only working values I have found are between 0.04 and 0.075 exclusive.
    //Anything else tends to be a bit wonky. Feel free to experiment.
    //Also a higher value means less gravity
    @Override
    public float getGravity() {
        return 0.07F;
    }

    //The moon is 7.0, 0 is none, lower numbers mean more
    @Override
    public double getMeteorFrequency() {
        return 4.0;
    }

    @Override
    public float getSoundVolReductionAmount() {
        return Float.MAX_VALUE;
    }

    @Override
    public float getThermalLevelModifier() {
        return -2;
    }

    @Override
    public float getWindLevel() {
        return 0;
    }

    @Override
    public boolean canRainOrSnow() {
        return false;
    }

    @Override
    public CelestialBody getCelestialBody()
    {
        return GalaxyMultiverse.planetFrigus;
    }

    @Override
    public Class<? extends IChunkProvider> getChunkProviderClass() {
        return FrigusChunkProvider.class;
    }

    @Override
    public long getDayLength() {
        return 24000L;
    }

    @Override
    public Vector3 getFogColor() {
        return new Vector3(0, 0, 0);
    }

    @Override
    public Vector3 getSkyColor() {
        return new Vector3(0, 0, 0);
    }

    @Override
    public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
        return FrigusWorldChunkManager.class;
    }

    @Override
    public boolean hasSunset() {
        return false;
    }

    @Override
    public boolean shouldForceRespawn()
    {
        return true;
    }

    @Override
    public double getSolarEnergyMultiplier()
    {
        return 0.85;
    }

    @Override
    public double getYCoordinateToTeleport()
    {
        return 250;
    }

    @Override
    public Vector3 getEntitySpawnLocation(WorldServer arg0, Entity arg1)
    {
        return new Vector3(arg1.posX, 140, arg1.posZ);
    }

    @Override
    public Vector3 getParaChestSpawnLocation(WorldServer arg0, EntityPlayerMP arg1, Random arg2)
    {
        //Randomize parachest spawn location
        return new Vector3(arg1.posX - 5 + arg2.nextInt(10), 150, arg1.posZ - 5 + arg2.nextInt(10));
    }

    @Override
    public Vector3 getPlayerSpawnLocation(WorldServer arg0, EntityPlayerMP arg1)
    {
        return getEntitySpawnLocation(arg0, arg1);
    }

    @Override
    public void onSpaceDimensionChanged(World arg0, EntityPlayerMP arg1, boolean arg2)
    {

    }

    @Override
    public boolean useParachute()
    {
        return true;
    }

    @Override
    public IRenderHandler getCloudRenderer()
    {
        //Removes clouds from dimension
        return new CloudRenderer();
    }
}
