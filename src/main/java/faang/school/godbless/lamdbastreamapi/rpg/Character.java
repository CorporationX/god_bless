package faang.school.godbless.lamdbastreamapi.rpg;

import java.util.ArrayList;
import java.util.List;

public class Character {
    String name;
    List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        if (inventory == null) {
            inventory = new ArrayList<>(List.of(item));
        } else {
            inventory.add(item);
        }
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
