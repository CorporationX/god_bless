package school.faang.sprint_3.task_49494;

import java.util.Collection;

public class ValidationUtils {
    public static <T> T isNotNull(T object, String exceptionObjectName) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s не может быть пустым (null)", exceptionObjectName));
        }
        return object;
    }

    public static <T> T isNotEmpty(T object, String exceptionObjectName) {
        if (object instanceof String && ((String) object).isEmpty()) {
            throw new IllegalArgumentException(String.format("Значение у %s не может быть пустым",
                    exceptionObjectName));
        }
        if (object instanceof Collection && ((Collection<?>) object).isEmpty()) {
            throw new IllegalArgumentException(String.format("Значение у %s не может быть пустым",
                    exceptionObjectName));
        }
        return object;
    }

    public static <T> T isNotNullAndNotEmpty(T object, String objectName) {
        isNotNull(object, objectName);
        isNotEmpty(object, objectName);
        return object;
    }
}
