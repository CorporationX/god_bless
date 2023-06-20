package middleearth;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Data
public class Character {
    private String name;
    private int maxInventorySize = 10;
    private final List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void inventoryUpgrade(Item item, Predicate<Item> checker) {
        if (checker.test(item)) {
            maxInventorySize += 10;
        }
    }

}
