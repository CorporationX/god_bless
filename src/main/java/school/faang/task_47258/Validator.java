package school.faang.task_47258;

public class Validator<T> {
    private static final String NULL_ERROR_MESSAGE = "Parameter can't be null";
    private static final String EMPTY_ERROR_MESSAGE = "Parameter can't be empty";


    public static <T> void validate(T parameter) {
        if (parameter == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    public static void validateName(String name) {
        Validator.validate(name);

        if (name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }
}
