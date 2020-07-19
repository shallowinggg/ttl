package com.nacre.ttl.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Shimin Ding
 * @date 2020/7/19
 * @since 1.0
 */
public class TtlComponentRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        TtlConfigUtils.registerTaskAnnotationProcessor(registry);

        // register network tools
    }
}
