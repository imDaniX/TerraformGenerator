package org.terraform.biome;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.terraform.data.TWSimpleLocation;
import org.terraform.data.TerraformWorld;

public class HeightIndependentBiomeCacheLoader implements CacheLoader<TWSimpleLocation, BiomeBank> {

    @Override
    public @Nullable BiomeBank load(@NotNull TWSimpleLocation loc) {
        int x = loc.getX();
        int z = loc.getZ();

        // This optimisation doesn't work here. Many aesthetic options rely on
        // the fact that this is block-accurate. Calculating once per 4x4 blocks
        // creates obvious ugly 4x4 artifacts
        // x = (x >> 2) << 2; z = (z >> 2) << 2;

        TerraformWorld tw = loc.getTerraformWorld();
        BiomeSection mostDominant = BiomeSection.getMostDominantSection(tw, x, z);
        return mostDominant.getBiomeBank();
    }

}
