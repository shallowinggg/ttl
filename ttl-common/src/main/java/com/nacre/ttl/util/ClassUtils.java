package com.nacre.ttl.util;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Convenient utility methods for class operation.
 *
 * @author ding shimin
 * @since 1.0
 */
public final class ClassUtils {


    /**
     * Return the parameter types for given method.
     *
     * @param method the method to check params
     * @return parameter types
     */
    public static Class<?>[] getMethodParameters(Method method) {
        Objects.requireNonNull(method, "method must not be null");
        return method.getParameterTypes();
    }

    /**
     * Return a simplified full qualified name for given class.
     * This method will only allow the first char of sub package
     * name exists. For example: <pre>
     *     Assert.equals("j.u.Date", java.utils.Date.class); // true
     * </pre>
     *
     * @param clazz the class to simplify
     * @return simplified full qualified class name
     */
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
