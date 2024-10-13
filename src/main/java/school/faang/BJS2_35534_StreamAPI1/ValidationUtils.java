package school.faang.BJS2_35534_StreamAPI1;

import java.util.List;

public class ValidationUtils {
    public static <T> void validateNotNull(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List can't be null!");
        }
    }

    public static <T> void validateNotNullOrEmpty(List<T> list) {
        validateNotNull(list);
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty!");
        }
    }

    public static void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
