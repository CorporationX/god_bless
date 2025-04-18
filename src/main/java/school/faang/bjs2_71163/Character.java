package school.faang.bjs2_71163;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Character {
    private final String name;
    private final Set<Item> items = new HashSet<>();

    public Character(String name) {
        this.name = name;
    }
}
