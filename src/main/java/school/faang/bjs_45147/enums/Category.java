package school.faang.bjs_45147.enums;

import lombok.Getter;
import school.faang.bjs_45147.exception.CategoryNotFoundException;

import java.util.Arrays;

@Getter
public enum Category {
    FRUITS("Фрукты"),
    VEGETABLES("Овощи"),
    DRINKS("Напитки"),
    MILK_PRODUCTS("Молочные продукты"),
    MEAT("Мясо"),
    CONFECTIONERY("Кондитерские изделия"),
    CEREALS("Крупы"),
    SPICES("Специи"),
    HOUSEHOLD_CHEMICALS("Бытовая химия"),
    COSMETICS("Косметика");

    private final String name;

    Category(String name) {
        this.name = name;

    }

    public static Category valueOfName(String categoryName) {
        return Arrays.stream(values())
                .filter(category -> categoryName.equalsIgnoreCase(category.getName()))
                .findFirst().orElseThrow(CategoryNotFoundException::new);
    }
}
