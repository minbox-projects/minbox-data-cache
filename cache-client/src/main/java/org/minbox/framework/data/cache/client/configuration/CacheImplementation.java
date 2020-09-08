package org.minbox.framework.data.cache.client.configuration;

import lombok.Getter;
import org.minbox.framework.data.cache.client.delegate.CacheDelegate;

/**
 * Define cache implementation
 *
 * @author 恒宇少年
 */
@Getter
public enum CacheImplementation {
    /**
     * Caffeine
     * https://github.com/ben-manes/caffeine
     */
    CAFFEINE("org.minbox.framework.data.cache.client.delegate.support.CaffeineCacheDelegate"),
    /**
     * Google Guava
     * https://github.com/google/guava
     */
    GUAVA("org.minbox.framework.data.cache.client.delegate.support.GuavaCacheDelegate");
    /**
     * The {@link CacheDelegate} class name
     */
    private String delegateClassName;

    CacheImplementation(String delegateClassName) {
        this.delegateClassName = delegateClassName;
    }
}
