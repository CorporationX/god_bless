package faang.school.godbless.BJS29071;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println(name + "'s invetory is empty");
        }
        inventory.forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
