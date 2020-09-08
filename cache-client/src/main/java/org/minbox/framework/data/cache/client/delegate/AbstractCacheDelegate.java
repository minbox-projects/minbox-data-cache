package org.minbox.framework.data.cache.client.delegate;

import org.minbox.framework.data.cache.client.configuration.CacheConfiguration;

/**
 * The {@link CacheDelegate} abstract implement
 *
 * @author 恒宇少年
 */
public abstract class AbstractCacheDelegate<K, V> implements CacheDelegate<K, V> {
    public AbstractCacheDelegate(CacheConfiguration configuration) {
        this.configure(configuration);
    }

    /**
     * Configure different implemented cache objects according to {@link CacheConfiguration}
     *
     * @param configuration The {@link CacheConfiguration} instance
     * @see org.minbox.framework.data.cache.client.delegate.support.CaffeineCacheDelegate#configure
     * @see org.minbox.framework.data.cache.client.delegate.support.GuavaCacheDelegate#configure
     */
    public abstract void configure(CacheConfiguration configuration);
}
