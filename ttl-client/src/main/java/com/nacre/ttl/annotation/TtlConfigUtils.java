package com.nacre.ttl.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author Shimin Ding
 * @date 2020/7/19
 * @since 1.0
 */
public class TtlConfigUtils {

    public static final String TASK_ANNOTATION_PROCESSOR_BEAN_NAME = "com.nacre.ttl.internalTaskAnnotationProcessor";

    public static void registerTaskAnnotationProcessor(BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition(TASK_ANNOTATION_PROCESSOR_BEAN_NAME)) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskAnnotationPostProcessor.class);
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            registry.registerBeanDefinition(TASK_ANNOTATION_PROCESSOR_BEAN_NAME, beanDefinition);
        }
    }
}
