package school.faang.LordOfTheRings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private List<Item> inventory;
    private String name;

    Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}
