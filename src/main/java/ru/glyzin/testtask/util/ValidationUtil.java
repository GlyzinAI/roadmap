package ru.glyzin.testtask.util;

import ru.glyzin.testtask.util.exception.NotFoundException;

public class ValidationUtil {
    public static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with name: " + msg);
        }
    }

    public static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }
}
