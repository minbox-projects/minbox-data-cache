package org.minbox.framework.data.cache.client;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.minbox.framework.data.cache.client.configuration.CacheConfiguration;
import org.minbox.framework.data.cache.client.delegate.CacheDelegate;
import org.minbox.framework.data.cache.client.delegate.CacheDelegateFactory;
import org.minbox.framework.data.cache.core.utils.Assert;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The cache object
 * <p>
 * Instantiate cache objects and provide methods to manipulate cached data
 *
 * @author 恒宇少年
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cache<K, V> {
    @Getter
    private String name;
    private CacheConfiguration configuration;
    private CacheDelegate<K, V> delegate;

    public Cache(String name) {
        this(name, CacheConfiguration.defaultConfiguration());
    }

    public Cache(String name, CacheConfiguration configuration) {
        Assert.notEmpty(name, "The cache name cannot be empty.");
        Assert.notNull(configuration, "The configuration class of the instantiated cache cannot be null.");
        this.name = name;
        this.configuration = configuration;
        this.delegate = CacheDelegateFactory.instance(configuration);
    }

    /**
     * Determine whether the value of the specified key exists in the cache
     *
     * @param key The key of the cache element
     * @return "true" if it exists
     */
    public boolean containsKey(K key) {
        return this.delegate.containsKey(key);
    }

    /**
     * Get a cache value by key
     *
     * @param key The key of the cache element
     * @return The value of the cache element
     */
    public V getCache(K key) {
        return this.delegate.getCache(key);
    }

    /**
     * Put a element to cache
     *
     * @param key   The key of the cache element
     * @param value The value of the cache element
     */
    public void putCache(K key, V value) {
        Assert.notEmpty(key, "The cache key cannot be empty.");
        Assert.notEmpty(value, "The cache value cannot be empty.");
        this.delegate.putCache(key, value);
    }

    /**
     * Put all elements in the map to the cache
     *
     * @param caches The cache {@link Map}
     */
    public void putCaches(Map<K, V> caches) {
        Assert.notEmpty(caches, "The cache map cannot be empty.");
        this.delegate.putAllCache(caches);
    }

    /**
     * Remove a cache by key
     *
     * @param key The key of the cache element
     */
    public void removeCache(K key) {
        Assert.notEmpty(key, "The cache key cannot by empty.");
        this.delegate.removeCache(key);
    }

    /**
     * Remove all cache keys in the specified {@link Set}
     *
     * @param keySet The cache key set
     */
    public void removeCaches(Set<K> keySet) {
        Assert.notEmpty(keySet, "The key set to be deleted cannot be empty.");
        Iterator<K> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            K key = iterator.next();
            this.removeCache(key);
        }
    }
}
