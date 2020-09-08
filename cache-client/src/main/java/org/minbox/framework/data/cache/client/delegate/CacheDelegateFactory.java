package org.minbox.framework.data.cache.client.delegate;

import lombok.extern.slf4j.Slf4j;
import org.minbox.framework.data.cache.client.configuration.CacheConfiguration;
import org.minbox.framework.data.cache.client.configuration.CacheImplementation;
import org.minbox.framework.data.cache.core.exception.CacheException;
import org.minbox.framework.data.cache.core.utils.Assert;

import java.lang.reflect.Constructor;

/**
 * Provide a way to build {@link CacheDelegate}
 *
 * @author 恒宇少年
 */
@Slf4j
public class CacheDelegateFactory {

    /**
     * Create {@link CacheDelegate} implementation class instance
     *
     * @param configuration The {@link CacheConfiguration} instance
     * @return The {@link CacheDelegate} implementation class instance
     */
    public static CacheDelegate instance(CacheConfiguration configuration) {
        Assert.notNull(configuration, "The CacheConfiguration cannot be null.");
        Assert.notNull(configuration.getImplementation(), "The CacheImplementation cannot be null.");
        try {
            CacheImplementation implementation = configuration.getImplementation();
            Class<?> delegateClass = Class.forName(implementation.getDelegateClassName());
            Constructor<CacheDelegate> constructor =
                    (Constructor<CacheDelegate>) delegateClass.getDeclaredConstructor(CacheConfiguration.class);
            CacheDelegate delegate = constructor.newInstance(configuration);
            return delegate;
        } catch (Exception e) {
            throw new CacheException(e.getMessage(), e);
        }
    }
}
