package com.nacre.ttl.handler;

import java.util.Arrays;

/**
 * @author ding shimin
 * @date 2020/7/20
 * @since 1.0
 */
public class ArgumentNotMatchException extends Exception {

    public ArgumentNotMatchException(Class<?>[] classes, Object[] args) {
        super("UnMatchable arguments: type: " + Arrays.toString(classes) + ", args: " + Arrays.toString(args));
    }

}
