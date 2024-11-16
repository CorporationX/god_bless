package faang.school.godbless.LordOfTheRings;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Character {
    @Getter
    private String name;
    private final List<Item> inventory = new ArrayList<>();

    Character(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        this.name = name;
    }

    public void addItem(Item item) {
        if (item != null) {
            inventory.add(item);
        }
    }

    public void removeItem(Predicate<Item> predicate) {
        if (predicate != null) {
            inventory.removeIf(predicate);
        }
    }

    public List<Item> getItems(Predicate<Item> predicate) {
        if (predicate == null) {
            return null;
        }

        return inventory.stream().filter(predicate).toList();
    }

    public void printInventory() {
        System.out.println("Character: " + this.name);
        if (inventory.isEmpty()) {
            System.out.println("Inventory: No items");
        } else {
            System.out.println("Inventory: ");
            inventory.forEach(item -> System.out.println("  " + item));
        }
    }
}
