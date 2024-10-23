package school.faang.carrygotfuckedup;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
        System.out.println("Added item to inventory: " + item.getName() + " with power: " + item.getPower());
    }

    public Item combineItems(Item item1, Item item2) {
        String combinedName = item1.getName() + " & " + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();
        return new Item(combinedName, combinedPower);
    }

    public void printInventory() {
        items.forEach(item -> System.out.println(item.getName() + " - Power: " + item.getPower()));
    }
}

