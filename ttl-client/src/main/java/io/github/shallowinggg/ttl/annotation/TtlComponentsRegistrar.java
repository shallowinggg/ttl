package io.github.shallowinggg.ttl.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ding shimin
 * @since 1.0
 */
public class TtlComponentsRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        TtlConfigUtils.registerTaskAnnotationBeanPostProcessor(registry);
    }
}
