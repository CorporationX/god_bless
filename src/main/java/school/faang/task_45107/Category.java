package school.faang.task_45107;

import java.util.Arrays;

public enum Category {
    Electronics,
    Food,
    Clothing;

    public static Category compareStrings(String comparingString) {
        return Arrays.stream(Category.values())
                .filter(category -> category.toString().equals(comparingString))
                .findFirst()
                .orElse(null);
    }
}


