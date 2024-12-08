package school.faang.task46219;

import lombok.Getter;

@Getter
public enum Filter {
    BLACK_WHITE("черно белый фильтр"),
    SEPIA("сепия");

    private final String name;

    Filter(String name) {
        this.name = name;
    }
}
