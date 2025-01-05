package school.faang.task_50812;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new CopyOnWriteArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        return new Item("Combined " + item1.name() + " & " + item2.name(),
                item1.power() + item2.power());
    }

}
