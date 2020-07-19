package com.nacre.ttl.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Shimin Ding
 * @date 2020/7/19
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(TtlComponentRegistrar.class)
public @interface EnableTtl {
}
