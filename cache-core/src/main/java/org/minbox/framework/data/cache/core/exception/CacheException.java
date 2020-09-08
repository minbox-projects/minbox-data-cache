package org.minbox.framework.data.cache.core.exception;

import lombok.NoArgsConstructor;

/**
 * The cache runtime exception
 *
 * @author 恒宇少年
 */
@NoArgsConstructor
public class CacheException extends RuntimeException {
    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }
}
