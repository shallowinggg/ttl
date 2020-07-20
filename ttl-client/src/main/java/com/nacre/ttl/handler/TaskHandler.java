package com.nacre.ttl.handler;

import java.lang.reflect.Method;

/**
 * @author ding shimin
 * @since 1.0
 */
public interface TaskHandler {

    /**
     * Invoke scheduling task with given arguments.
     * If given arguments is not matched with task params for different amount or
     * incompatible type will cause {@link ArgumentNotMatchException} thrown.
     *
     * @param args task method arguments
     * @throws Exception if task exec fail
     */
    void invoke(Object... args) throws Exception;

    /**
     * Return the source of this task handler. Typically, the task handler is built
     * from a {@code Method}.
     *
     * @return the source of task handler
     */
    Method getSource();
}
