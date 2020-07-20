package com.nacre.ttl.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ding shimin
 * @date 2020/7/20
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(TtlComponentsRegistrar.class)
public @interface EnableTtl {
}
