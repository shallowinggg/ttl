package io.github.shallowinggg.ttl.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ding shimin
 * @date 2020/7/20
 */
public class ClassUtilsTest {

    @Test
    public void testSimplyFullClassName() {
        Assertions.assertEquals("c.n.t.u.ClassUtilsTest", ClassUtils.simplyFullClassName(getClass()));
        Assertions.assertEquals("c.n.t.u.ClassUtilsTest$Inner", ClassUtils.simplyFullClassName(Inner.class));
    }


    public static class Inner {
    }
}
