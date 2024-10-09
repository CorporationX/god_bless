package school.faang.rpg;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;

    public Character(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Невозможно создать персонажа без имени");
        }

        this.name = name;
    }

    public List<Item> inventory = new ArrayList<>();
}
