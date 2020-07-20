package com.nacre.ttl.handler;

import com.nacre.ttl.util.ClassUtils;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author ding shimin
 * @since 1.0
 */
public class MethodReflectTaskHandler extends AbstractTaskHandler {

    private final Object bean;

    private final Method method;

    protected MethodReflectTaskHandler(Object bean, Method method) {
        super(ClassUtils.getMethodParameters(method));

        Assert.notNull(bean, "bean must not be null");
        if (!method.isAccessible()) {
            ReflectionUtils.makeAccessible(method);
        }
        this.method = method;
        this.bean = bean;
    }

    @Override
    protected void invokeInternal() throws Exception {
        method.invoke(bean, actualArgs);
    }

    @Override
    public Method getSource() {
        return method;
    }
}
