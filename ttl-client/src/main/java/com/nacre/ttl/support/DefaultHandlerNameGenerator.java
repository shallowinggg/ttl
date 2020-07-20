package com.nacre.ttl.support;

import com.nacre.ttl.handler.TaskHandler;
import com.nacre.ttl.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * Default strategy interface for generating handler names for {@code TaskHandler}.
 * It uses {@link TaskHandler#getSource()} to generate name with this method's
 * name and its declaring class name. For example:
 * <pre><code>
 *     Date o = new Date();
 *     Method m = o.getClass().getDeclaredMethod("hashCode");
 *     TaskHandler handler = new MethodReflectTaskHandler(o, m);
 *     String handlerName = DefaultHandlerNameGenerator.INSTANCE.generateHandlerName(handler);
 *     Assert.equals("j.u.Date.hashCode", handlerName); // ture
 * </code>
 * </pre>
 *
 * @author ding shimin
 * @date 2020/7/20
 * @since 1.0
 */
public class DefaultHandlerNameGenerator implements HandlerNameGenerator {

    public static final DefaultHandlerNameGenerator INSTANCE = new DefaultHandlerNameGenerator();

    @Override
    public String generateHandlerName(TaskHandler handler) {
        Method method = handler.getSource();
        if (method == null) {
            return null;
        }
        return ClassUtils.simplyFullClassName(method.getDeclaringClass()) + "#" + method.getName();
    }
}
