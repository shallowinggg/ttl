package com.nacre.ttl.annotation;

import java.lang.annotation.*;

/**
 * @author Shimin Ding
 * @date 2020/7/19
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Task {

    String name() default "";

    String value();
}
