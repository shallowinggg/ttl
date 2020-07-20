package com.nacre.ttl.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author ding shimin
 * @date 2020/7/20
 * @since 1.0
 */
public class TtlConfigUtils {

    public static final String TASK_ANNOTATION_PROCESSOR_BEAN_NAME = "internalTaskAnnotationBeanPostProcessor";

    public static void registerTaskAnnotationBeanPostProcessor(BeanDefinitionRegistry registry) {
        if (!registry.containsBeanDefinition(TASK_ANNOTATION_PROCESSOR_BEAN_NAME)) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(TaskAnnotationBeanPostProcessor.class);
            beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
            registry.registerBeanDefinition(TASK_ANNOTATION_PROCESSOR_BEAN_NAME, beanDefinition);
        }
    }

    private TtlConfigUtils() {
    }
}
