package com.nacre.ttl.support;

import com.nacre.ttl.handler.TaskHandler;

/**
 * Strategy interface for generating handler names for {@code TaskHandler}.
 *
 * @author ding shimin
 * @date 2020/7/20
 * @since 1.0
 */
@FunctionalInterface
public interface HandlerNameGenerator {

    /**
     * Generate a name for the given task handler.
     *
     * @param handler the task handler
     * @return the generated handler name
     */
    String generateHandlerName(TaskHandler handler);
}
