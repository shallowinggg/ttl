package io.github.shallowinggg.ttl.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author ding shimin
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(TtlComponentsRegistrar.class)
public @interface EnableTtl {
}
