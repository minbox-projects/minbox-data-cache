package org.minbox.framework.data.cache.client.listener;

/**
 * Cache removal listener
 * <p>
 * The listener is triggered by the internally delegated cache implementation
 *
 * @author 恒宇少年
 */
@FunctionalInterface
public interface CacheRemoveListener {
    /**
     * Notification method after cache deletion
     *
     * @param notification Notification entity instance
     */
    void listen(CacheRemovalNotification notification);
}
