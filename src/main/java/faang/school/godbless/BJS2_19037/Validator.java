package faang.school.godbless.BJS2_19037;

public class Validator {
    public static void validateNotEmpty(String name, String fieldName) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    public static void validatePositive(int value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " must be greater than 0");
        }
    }

    public static void validateNonNegative(int value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
    }
}
