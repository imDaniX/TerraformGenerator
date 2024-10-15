package org.terraform.coregen;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.jetbrains.annotations.NotNull;

public class ChunkCacheLoader implements CacheLoader<ChunkCache, ChunkCache> {

    @Override
    public @NotNull ChunkCache load(@NotNull ChunkCache key) {
        key.initInternalCache();
        return key;
    }

}
