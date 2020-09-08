package org.minbox.framework.data.cache.client.delegate.support;

import com.google.common.cache.CacheBuilder;
import org.minbox.framework.data.cache.client.configuration.CacheConfiguration;
import org.minbox.framework.data.cache.client.delegate.AbstractCacheDelegate;
import org.minbox.framework.data.cache.client.delegate.CacheDelegate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Google guava way of implementation of {@link CacheDelegate}
 *
 * @author 恒宇少年
 */
public class GuavaCacheDelegate<K, V> extends AbstractCacheDelegate<K, V> {
    private com.google.common.cache.Cache<K, V> cache;

    public GuavaCacheDelegate(CacheConfiguration configuration) {
        super(configuration);
    }

    /**
     * Configure guava cache instance
     *
     * @param configuration The {@link CacheConfiguration} instance
     */
    @Override
    public void configure(CacheConfiguration configuration) {
        CacheBuilder cacheBuilder =
                CacheBuilder.newBuilder()
                        .initialCapacity(configuration.getInitialCapacity())
                        .maximumSize(configuration.getMaximumSize());
        // configure expireAfterAccess
        if (configuration.getExpireAfterAccessMillis() > 0) {
            cacheBuilder.expireAfterAccess(configuration.getExpireAfterAccessMillis(), TimeUnit.MILLISECONDS);
        }
        // configure expireAfterWrite
        if (configuration.getExpireAfterWriteMillis() > 0) {
            cacheBuilder.expireAfterWrite(configuration.getExpireAfterWriteMillis(), TimeUnit.MILLISECONDS);
        }
        this.cache = cacheBuilder.build();
    }

    @Override
    public int size() {
        return Long.valueOf(this.cache.size()).intValue();
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
