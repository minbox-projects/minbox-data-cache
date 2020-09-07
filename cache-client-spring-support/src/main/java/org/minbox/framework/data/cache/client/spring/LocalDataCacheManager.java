package org.minbox.framework.data.cache.client.spring;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * The {@link LocalDataCache} manager
 *
 * @author 恒宇少年
 */
public class LocalDataCacheManager extends AbstractCacheManager {
    @Override
    protected Collection<? extends Cache> loadCaches() {
        return null;
    }

    @Override
    protected Cache getMissingCache(String name) {
        // TODO 实现实例化缓存对象并返回
        return null;
    }
}
