package io.github.shallowinggg.ttl.support;

import io.github.shallowinggg.ttl.handler.TaskHandler;

/**
 * Strategy interface for generating handler names for {@code TaskHandler}.
 *
 * @author ding shimin
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
