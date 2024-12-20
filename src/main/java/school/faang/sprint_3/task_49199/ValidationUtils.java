package school.faang.sprint_3.task_49199;

public class ValidationUtils {

    public static <T> T isNotNull(T object, String exceptionObjectName) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s не может быть пустым (null)", exceptionObjectName));
        }
        return object;
    }
}
