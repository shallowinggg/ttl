package com.nacre.ttl.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ding shimin
 * @date 2020/7/20
 * @since 1.0
 */
public class TtlComponentsRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        TtlConfigUtils.registerTaskAnnotationBeanPostProcessor(registry);
    }
}
