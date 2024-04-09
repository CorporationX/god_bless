package faang.school.godbless.lordOfRings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private final String name;

    public Character(String name) {
        this.name = name;
    }
}
