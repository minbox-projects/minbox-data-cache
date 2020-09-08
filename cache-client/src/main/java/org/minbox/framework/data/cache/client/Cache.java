package org.minbox.framework.data.cache.client;

import org.minbox.framework.data.cache.client.configuration.CacheConfiguration;
import org.minbox.framework.data.cache.client.delegate.CacheDelegate;
import org.minbox.framework.data.cache.client.delegate.CacheDelegateFactory;
import org.minbox.framework.data.cache.core.utils.Assert;

/**
 * The cache object
 * <p>
 * Instantiate cache objects and provide methods to manipulate cached data
 *
 * @author 恒宇少年
 */
public class Cache {
    private String name;
    private CacheConfiguration configuration;
    private CacheDelegate delegate;

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
}
