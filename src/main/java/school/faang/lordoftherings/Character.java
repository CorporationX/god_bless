package school.faang.lordoftherings;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Character {
    private final String name;
    private final Set<Item> inventory;

    public Character(String name) {
        this.name = name;
        inventory = new HashSet<>();
    }
}
