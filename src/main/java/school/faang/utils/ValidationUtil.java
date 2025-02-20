package school.faang.utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ValidationUtil {
    public static void isValidString(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or blank.");
        }
    }

    public static void isValidLocalDateTime(LocalDateTime localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException("LocalDate can't be null.");
        }
    }

    public static <T> void isValidList(List<T> list, String message) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List of " + message + "(e)s can't be null or empty.");
        }
        if (list.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(message + " in list can't be null.");
        }
    }
}
