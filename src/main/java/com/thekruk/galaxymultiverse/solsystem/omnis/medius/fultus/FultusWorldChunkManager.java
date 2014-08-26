package com.thekruk.galaxymultiverse.solsystem.omnis.medius.fultus;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldChunkManagerSpace;
import net.minecraft.world.biome.BiomeGenBase;

public class FultusWorldChunkManager extends WorldChunkManagerSpace
{
    @Override
    public BiomeGenBase getBiome()
    {
        return BiomeGenBase.desert;
    }
}
