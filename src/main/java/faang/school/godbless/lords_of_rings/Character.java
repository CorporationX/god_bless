package faang.school.godbless.lords_of_rings;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
        this.inventory = new ArrayList<Item>();
    }

    public List<Item> getInventory() {
        return inventory;
    }
}
