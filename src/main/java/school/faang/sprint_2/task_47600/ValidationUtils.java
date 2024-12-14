package school.faang.sprint_2.task_47600;

public class ValidationUtils {

    public static <T> T isNotNull(T object, String exceptionMessage) {
        if (object == null) {
            throw new IllegalArgumentException(exceptionMessage);
        }
        return object;
    }

    public static <T> T isNotNull(T object) {
        return isNotNull(object, "Входные параметры не могут быть пустыми");
    }
}
