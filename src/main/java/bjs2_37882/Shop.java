package bjs2_37882;

import java.util.List;

public class Shop {
    private final List<Item> items = List.of(
            new Item("Flask", 0),
            new Item("Yasha", 50),
            new Item("Sasha", 50),
            new Item("Dust", 0)
    );

    public Item sell(Item item) {
        if (items.contains(item)) {
            return item;
        } else {
            throw new IllegalArgumentException("Item not found");
        }
    }
}
