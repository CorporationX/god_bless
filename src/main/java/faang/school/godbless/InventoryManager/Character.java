package faang.school.godbless.InventoryManager;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private List<Item> inventory = new ArrayList<>();
    private String name;

    public Character(String name) {
        this.name = name;
    }

    public void addInventory(Item inventory) {
        this.inventory.add(inventory);
    }

    public void removeItem(Item inventory) {
        this.inventory.remove(inventory);
    }

    public void updateItem(int index, Item inventory) {
        this.inventory.set(index, inventory);
    }
}
