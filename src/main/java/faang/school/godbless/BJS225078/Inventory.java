package faang.school.godbless.BJS225078;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Getter
@Slf4j
public class Inventory {
    private final List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        log.info("Added {} to inventory", item);
    }

    public Item combineItems(Item item1, Item item2) {
        String name = item1.getName() + "+" + item2.getName();
        int power = item1.getPower() + item2.getPower();
        Item combinedItem = new Item(name, power);
        log.info("Combined {} and {} into {}", item1, item2, combinedItem);
        return combinedItem;
    }
}

