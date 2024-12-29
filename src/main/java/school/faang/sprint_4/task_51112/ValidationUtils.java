package school.faang.sprint_4.task_51112;

public class ValidationUtils {
    public static <T> T isNotNull(T object, String exceptionObjectName) {
        if (object == null) {
            throw new IllegalArgumentException(String.format("%s не может быть пустым (null)", exceptionObjectName));
        }
        return object;
    }

    public static <T extends Number> T isPositive(T number, String exceptionObjectName) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException(String.format("%s должна быть больше 0", exceptionObjectName));
        }
        return number;
    }
}
