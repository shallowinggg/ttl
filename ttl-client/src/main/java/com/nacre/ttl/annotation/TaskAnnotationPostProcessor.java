package com.nacre.ttl.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Shimin Ding
 * @date 2020/7/19
 * @since 1.0
 */
public class TaskAnnotationPostProcessor implements BeanPostProcessor {

    private final Log logger = LogFactory.getLog(TaskAnnotationPostProcessor.class);
}
