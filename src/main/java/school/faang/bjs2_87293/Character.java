package school.faang.bjs2_87293;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("У персонажа должно быть имя!");
        }
        this.name = name;
    }
}
