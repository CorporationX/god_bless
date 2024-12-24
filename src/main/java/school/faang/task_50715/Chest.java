package school.faang.task_50715;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Chest {
    private static final List<Item> items = List.of(new Item("Sword", 10),
            new Item("Bow", 5), new Item("Bar", 3));

    public static synchronized Item getRandomItem() {
        return items.get(ThreadLocalRandom.current()
                .nextInt(items.size()));
    }
}
