package org.minbox.framework.data.cache.client.listener;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.minbox.framework.data.cache.core.enums.CacheRemovalCause;
import org.minbox.framework.data.cache.core.utils.Assert;

/**
 * The cache removal notification entity
 * <p>
 * This class instance is passed through the {@link CacheRemoveListener#listen} method
 *
 * @author 恒宇少年
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CacheRemovalNotification {
    private Object key;
    private Object value;
    private CacheRemovalCause cause;
    private long removalMillis = System.currentTimeMillis();

    public CacheRemovalNotification(Object key, Object value, CacheRemovalCause cause) {
        Assert.notEmpty(key, "The cache key cannot be empty.");
        Assert.notNull(value, "The cache value cannot be null.");
        Assert.notNull(cause, "The cache removal cause cannot be null.");
        this.key = key;
        this.value = value;
        this.cause = cause;
    }
}
