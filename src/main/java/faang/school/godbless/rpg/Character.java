package faang.school.godbless.rpg;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

}
