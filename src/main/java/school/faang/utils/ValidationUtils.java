package school.faang.utils;

import school.faang.models.Category;

import java.time.LocalDate;
import java.util.List;

public class ValidationUtils {
    private ValidationUtils() {
    }

    public static <T> void isValidList(List<T> list, String message) {
        if (list == null) {
            throw new IllegalArgumentException("List of " + message + "s can't be null.");
        }
        for (var entry : list) {
            if (entry == null) {
                throw new IllegalArgumentException(message + " in list can't be null.");
            }
        }
    }

    public static void isValidString(String argument, String message) {
        if (argument == null || argument.isBlank()) {
            throw new IllegalArgumentException("The " + message + " can't be null or blank.");
        }
    }

    public static void isValidPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("The price must be greater than zero.");
        }
    }

    public static void isValidCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("The category can't be null.");
        }
    }

    public static void isValidLocalDate(LocalDate orderDate) {
        if (orderDate == null) {
            throw new IllegalArgumentException("The orderDate can't be null or empty.");
        }
    }
}
