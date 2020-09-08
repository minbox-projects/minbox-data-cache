package org.minbox.framework.data.cache.core.enums;

/**
 * The cache removal cause
 *
 * @author 恒宇少年
 * @see com.google.common.cache.RemovalCause
 * @see com.github.benmanes.caffeine.cache.RemovalCause
 */
public enum CacheRemovalCause {
    EXPLICIT,
    REPLACED,
    COLLECTED,
    EXPIRED,
    SIZE
}
