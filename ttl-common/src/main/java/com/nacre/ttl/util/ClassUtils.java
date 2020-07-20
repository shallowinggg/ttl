package com.nacre.ttl.util;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author ding shimin
 * @date 2020/7/20
 */
public class ClassUtils {


    public static Class<?>[] getMethodParameters(Method method) {
        Objects.requireNonNull(method, "method must not be null");
        return method.getParameterTypes();
    }

    public static String simplyFullClassName(Class<?> clazz) {
        String fullName = clazz.getName();
        String[] names = fullName.split("\\.");
        StringBuilder builder = new StringBuilder(fullName.length());

        int packageLen = names.length - 1;
        int i = 0;
        while (i < packageLen) {
            String packageName = names[i];
            builder.append(packageName.charAt(0)).append(".");
            ++i;
        }
        builder.append(names[i]);
        return builder.toString();
    }

    private ClassUtils() {
    }
}
