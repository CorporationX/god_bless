package carry;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Shop {

    private final static List<Item> ITEMS = List.of(
            new Item("Item 1", 10),
            new Item("Item 2", 15),
            new Item("Item 3", 20),
            new Item("Item 4", 5),
            new Item("Item 5", 30),
            new Item("Item 6", 10),
            new Item("Item 7", 15),
            new Item("Item 8", 13),
            new Item("Item 9", 22)
    );

    public static Item getItem() {
        return ITEMS.get(ThreadLocalRandom.current().nextInt(0, ITEMS.size()));
    }
}
