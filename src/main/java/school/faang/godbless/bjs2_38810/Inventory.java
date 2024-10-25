package school.faang.godbless.bjs2_38810;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
        log.info("Added item {} to inventory", item);
    }

    public synchronized List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Item combineItems(Item item1, Item item2) {
        Item combined = new Item(item1.getName() + "+" + item2.getName(), item1.getPower() + item2.getPower());
        log.info("Item 1 : {} Item 2: {} Combined: {}", item1, item2, combined);
        return combined;
    }
}
