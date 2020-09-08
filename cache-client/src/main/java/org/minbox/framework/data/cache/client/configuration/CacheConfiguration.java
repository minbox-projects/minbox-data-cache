package org.minbox.framework.data.cache.client.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.minbox.framework.data.cache.client.Cache;
import org.minbox.framework.data.cache.client.listener.CacheRemoveListener;

import java.util.List;

/**
 * The configuration needed to build the {@link Cache}
 *
 * @author 恒宇少年
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheConfiguration {
    /**
     * Initialize the number of cache collections
     */
    private int initialCapacity = 1;
    /**
     * Maximum number of caches
     * <p>
     * The default value is {@link Integer#MAX_VALUE}
     */
    private int maximumSize = Integer.MAX_VALUE;
    /**
     * Specify how long the object expires after being written to the cache
     */
    private long expireAfterWriteMillis;
    /**
     * Specify how long the object expires after not being accessed
     */
    private long expireAfterAccessMillis;
    /**
     * Cache implementation method definition
     * <p>
     * {@link CacheImplementation#CAFFEINE} is used by default
     */
    private CacheImplementation implementation = CacheImplementation.CAFFEINE;
    /**
     * The {@link CacheRemoveListener} instance
     */
    private CacheRemoveListener removeListener;

    public static CacheConfiguration defaultConfiguration() {
        return new CacheConfiguration();
    }
}
