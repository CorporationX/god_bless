package school.faang.lord.of.the.rings;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        this.name = name;
    }

    public List<Item> getInventory() {
        return new ArrayList<>(inventory);
    }

    public void setInventory(List<Item> inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("inventory не может быть null");
        }
        this.inventory = inventory;
    }
}
