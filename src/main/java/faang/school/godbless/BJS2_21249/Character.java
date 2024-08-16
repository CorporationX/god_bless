package faang.school.godbless.BJS2_21249;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
    private final Map<Item, Integer> inventoryMap = new HashMap<>();
    @Setter
    private int itemCounter = 0;

    public Character(String name) {
        this.name = name;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
        this.inventoryMap.clear();

        int inventorySize = inventory.size();

        for (int i = 0; i < inventorySize; i++) {
            this.inventoryMap.put(inventory.get(i), i);
        }
        this.itemCounter = inventorySize;
    }
}
