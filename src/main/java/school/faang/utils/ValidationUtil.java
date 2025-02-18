package school.faang.utils;

import school.faang.City;
import school.faang.Location;

import java.util.List;
import java.util.Objects;

public class ValidationUtil {
    public static void isValidString(String string, String message) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or blank.");
        }
    }

    public static void isValidLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location can't be null or blank.");
        }
    }

    public static <T> void isValidList(List<T> list, String message) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List of " + message + " can't be null or empty.");
        }
        if (list.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException(message + " in list can't be null.");
        }
    }

    public static void isValidCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City can't be null.");
        }
    }
}
