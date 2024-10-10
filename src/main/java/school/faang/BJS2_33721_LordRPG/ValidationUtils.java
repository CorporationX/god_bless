package school.faang.BJS2_33721_LordRPG;

public class ValidationUtils {
    public static void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validatePositiveInteger(int value, String message) {
        if (value <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null!");
        }
    }
}
