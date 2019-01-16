package com.chiennd.demo.utility;

import java.util.Collection;

public class CollectionUtil {
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isEmpty(Object[] objects) {
        return (objects == null || objects.length == 0);
    }
}
