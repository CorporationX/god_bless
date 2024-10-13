package school.faang_sprint_2.lord_of_the_rings_rpg;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
