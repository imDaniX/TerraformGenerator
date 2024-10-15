package org.terraform.biome;


import com.github.benmanes.caffeine.cache.CacheLoader;
import org.jetbrains.annotations.NotNull;

public class BiomeSectionCacheLoader implements CacheLoader<BiomeSection, BiomeSection> {

    @Override
    public @NotNull BiomeSection load(@NotNull BiomeSection key) {
        key.doCalculations();
        return key;
    }

}