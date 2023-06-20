package faang.school.godbless.LOTR;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        if (this.inventory == null) {
            this.inventory = new ArrayList<>();
        }
        this.inventory.add(item);
    }

    public void removeItem(Item item) {
        if (this.inventory == null) {
            throw new IllegalArgumentException("Empty inventory");
        }
        this.inventory.remove(item);
    }

    public void updateItem(int index,Item item) {
        if (this.inventory == null) {
            throw new IllegalArgumentException("Empty inventory");
        }
        this.inventory.remove(index);
        this.inventory.add(index, item);
    }
}
