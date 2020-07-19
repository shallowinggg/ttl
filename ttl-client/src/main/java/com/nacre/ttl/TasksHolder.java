package com.nacre.ttl;

import java.util.Set;

/**
 * @author Shimin Ding
 * @date 2020/7/19
 * @since 1.0
 */
@FunctionalInterface
public interface TasksHolder {

    Set<String> getSchedulingTasks();
}
