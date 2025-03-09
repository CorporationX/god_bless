package school.faang.lord_of_the_rings_rpg;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public List<Item> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public Character(String name) {
        this.name = name;
    }
}
