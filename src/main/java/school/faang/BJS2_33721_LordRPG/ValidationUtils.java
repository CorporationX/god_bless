package school.faang.BJS2_33721_LordRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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

    public static void validateCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("Character can't be null!");
        }
    }

    public static void validateConsumer(Consumer<?> consumer, String message) {
        if (consumer == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validatePredicate(Predicate<?> predicate, String message) {
        if (predicate == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateFunction(Function<?, ?> function, String message) {
        if (function == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
