package faang.school.godbless.Task_Lord_of_the_Rings;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {

    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name, List<Item> inventory) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.inventory = inventory;
        }
    }

    public void addItemToInventory(Item item) {
        if (this.inventory.contains(item)) {
            System.out.println("The item is already in inventory");
        } else {
            this.inventory.add(item);
        }
    }

}
