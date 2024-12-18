package school.faang.sprint_3.task_48370;

public class ValidationUtils {

    public static <T> void isNotNull(T object, String exceptionObjectName) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s не может быть пустым (null)", exceptionObjectName));
        }
    }
}
