package school.faang.sprint2.task45673lordofthering;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
    private Integer costItems = 0;

    Character(String name) {
        this.name = name;
    }

    public void addItemToInventory(Item itemName) {
        inventory.add(itemName);
    }

    public void calculateCostItems(Item item) {
        costItems += item.getValue();
    }
}
