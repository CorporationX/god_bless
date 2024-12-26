package school.faang.task_50715;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Shop {
    private static final List<Item> items = List.of(new Item("Shield", 10),
            new Item("Potion", 2), new Item("Axe", 7));

    public static synchronized Item getRandomItem() {
        return items.get(ThreadLocalRandom.current()
                .nextInt(items.size()));
    }
}
