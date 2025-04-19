package school.faang.rpg;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private final String name;
    private final List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getInventory() {
        return inventory;
    }
}