package faang.school.godbless.model;

import java.util.List;

public record Inventory(
        List<Item> items
) {
    public void addItem(Item item) {
        items.add(item);
    }

    public Item  combineItem(Item item1, Item item2) {
        return new Item(
                item1.name() + "_" + item2.name(),
                item1.power() + item2.power()
        );
    }
}
