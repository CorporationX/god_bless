package school.faang.sprint2.task45673lordofthering;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();

    Character(String name) {
        this.name = name;
    }

    public void addItemToInventory(Item itemName) {
        inventory.add(itemName);
    }

    public Integer inventoryCost() {
        return inventory.stream()
                .map(Item::getValue)
                .reduce(0, (item1, item2) -> item1 + item2);
    }
}
