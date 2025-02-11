package school.faang;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private final String name;

    public Character(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or empty. Provided value " + name);
        }
    }
}
