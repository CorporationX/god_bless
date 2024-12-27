package school.faang.sprint_4.task_50698;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        String newItemName = firstItem.name() + " " + secondItem.name();
        int newItemPower = firstItem.power() + secondItem.power();
        return new Item(newItemName, newItemPower);
    }
}
