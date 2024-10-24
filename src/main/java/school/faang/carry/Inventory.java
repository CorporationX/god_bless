package school.faang.carry;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        int newPower = firstItem.getPower() + secondItem.getPower();
        String newName = firstItem.getName() + "-" + secondItem.getName();
        return new Item(newName, newPower);
    }

    public void printAllItems() {
        items.forEach(System.out::println);
    }
}