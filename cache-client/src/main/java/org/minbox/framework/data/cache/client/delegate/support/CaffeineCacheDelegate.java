package org.minbox.framework.data.cache.client.delegate.support;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.minbox.framework.data.cache.client.configuration.CacheConfiguration;
import org.minbox.framework.data.cache.client.delegate.AbstractCacheDelegate;
import org.minbox.framework.data.cache.client.delegate.CacheDelegate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Caffeine way of implementation of {@link CacheDelegate}
 *
 * @author 恒宇少年
 */
public class CaffeineCacheDelegate<K, V> extends AbstractCacheDelegate<K, V> {
    /**
     * The Caffeine cache instance
     */
    private com.github.benmanes.caffeine.cache.Cache<K, V> cache;

    public CaffeineCacheDelegate(CacheConfiguration configuration) {
        super(configuration);
    }

    /**
     * Configure caffeine cache instance
     *
     * @param configuration The {@link CacheConfiguration} instance
     */
    @Override
    public void configure(CacheConfiguration configuration) {
        Caffeine caffeine =
                Caffeine.newBuilder()
                        .initialCapacity(configuration.getInitialCapacity())
                        .maximumSize(configuration.getMaximumSize());
        // configure expireAfterAccess
        if (configuration.getExpireAfterAccessMillis() > 0) {
            caffeine.expireAfterAccess(configuration.getExpireAfterAccessMillis(), TimeUnit.MILLISECONDS);
        }
        // configure expireAfterWrite
        if (configuration.getExpireAfterWriteMillis() > 0) {
            caffeine.expireAfterWrite(configuration.getExpireAfterWriteMillis(), TimeUnit.MILLISECONDS);
        }
        this.cache = caffeine.build();
    }

    @Override
    public int size() {
        return this.cache.asMap().size();
    }

    @Override
    public void clear() {
        this.cache.invalidateAll();
    }

    @Override
    public boolean containsKey(K key) {
        return this.cache.getIfPresent(key) != null;
    }

    @Override
    public V getCache(K key) {
        return this.cache.getIfPresent(key);
    }

    @Override
    public void putCache(K key, V value) {
        this.cache.put(key, value);
    }

    @Override
    public void putAllCache(Map<K, V> caches) {
        this.cache.putAll(caches);
    }

    @Override
    public void removeCache(K key) {
        this.cache.invalidate(key);
    }
}
