package com.thekruk.galaxymultiverse.solsystem.omnis.medius.fultus;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.entities.player.GCEntityPlayerMP;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.Random;

public class FultusTeleportType implements ITeleportType
{
    @Override
    public boolean useParachute() {
        return true;
    }
    @Override
    public Vector3 getPlayerSpawnLocation(WorldServer world, EntityPlayerMP player)
    {
        if (player instanceof GCEntityPlayerMP)
        {
            return new Vector3(((GCEntityPlayerMP) player).getPlayerStats().coordsTeleportedFromX, ConfigManagerCore.disableLander ? 250.0 : 900.0, ((GCEntityPlayerMP) player).getPlayerStats().coordsTeleportedFromZ);
        }
        return null;
    }
    @Override
    public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity) {
        return new Vector3(entity.posX, 250, entity.posZ);
    }
    @Override
    public Vector3 getParaChestSpawnLocation(WorldServer world, EntityPlayerMP player, Random rand)
    {
        return new Vector3(player.posX, 250, player.posZ);
    }
    @Override
    public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player, boolean ridingAutoRocket)
    {
        if (!ridingAutoRocket && player instanceof GCEntityPlayerMP && ((GCEntityPlayerMP) player).getPlayerStats().teleportCooldown <= 0)
        {
            final GCEntityPlayerMP gcPlayer = (GCEntityPlayerMP) player;
            if (gcPlayer.capabilities.isFlying)
            {
                gcPlayer.capabilities.isFlying = false;
            }
            gcPlayer.getPlayerStats().teleportCooldown = 10;
        }
    }

}
