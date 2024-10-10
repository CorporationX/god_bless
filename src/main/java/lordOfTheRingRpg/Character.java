package lordOfTheRingRpg;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item itemToUpdate) {
        inventory.add(itemToUpdate);
    }

    public void removeItem(Item itemToDelete) {
        inventory.remove(itemToDelete);
    }
}