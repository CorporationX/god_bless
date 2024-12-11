package school.faang.task_45560;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        validateName(name);

        this.name = name;
        this.inventory = new ArrayList<>();
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name don't be null or blank!");
        }
    }
}
