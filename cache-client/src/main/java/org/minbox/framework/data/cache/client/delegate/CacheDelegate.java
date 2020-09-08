package org.minbox.framework.data.cache.client.delegate;

import java.util.Map;

/**
 * The Cache implement delegate function
 *
 * @author 恒宇少年
 * @see org.minbox.framework.data.cache.client.delegate.support.CaffeineCacheDelegate
 * @see org.minbox.framework.data.cache.client.delegate.support.GuavaCacheDelegate
 */
public interface CacheDelegate<K, V> {
    /**
     * Get total number of cached data
     *
     * @return Total number of cached data
     */
    int size();

    /**
     * Clear all cache
     */
    void clear();

    /**
     * Determine whether the key exists
     *
     * @param key The cache key
     * @return If the cache of the specified Key exists, return true
     */
    boolean containsKey(K key);

    /**
     * Get cache content according to key
     *
     * @param key The cache key
     * @return The cache content
     */
    V getCache(K key);

    /**
     * Set cache content
     *
     * @param key   The cache key
     * @param value The cache content
     */
    void putCache(K key, V value);

    /**
     * Merge the cache in the map
     *
     * @param caches The map caches
     */
    void putAllCache(Map<K, V> caches);

    /**
     * Delete the cache of the specified key
     *
     * @param key The cache key
     */
    void removeCache(K key);
}
