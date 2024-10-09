package school.faang.sprint_2.bjs2_33712;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Character {
    private final String name;
    private final Set<Item> inventory;

    Character(String name) {
        this.name = name;
        this.inventory = new HashSet<>();
    }
}
