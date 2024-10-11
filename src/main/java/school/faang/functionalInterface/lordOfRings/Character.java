package school.faang.functionalInterface.lordOfRings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private String name;

    public Character(String name) {
        fieldValidation(name);
        this.name = name;
    }

    private void fieldValidation(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
}
