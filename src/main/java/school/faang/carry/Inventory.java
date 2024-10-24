package school.faang.carry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    private static final Logger log = LoggerFactory.getLogger(Inventory.class);
    private final Lock lock = new ReentrantLock();
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        lock.lock();
        try {
            items.add(item);
            log.info("Предмет {} был добавлен в инвентарь", item);
        } finally {
            lock.unlock();
        }
    }

    public CompletableFuture<Item> combineItem(Item item1, Item item2) {
        return CompletableFuture.supplyAsync(() -> {
            String name = item1.getName() + "+" + item2.getName();
            int power = item1.getPower() + item2.getPower();
            return new Item(name, power);
        });
    }

    public CompletableFuture<Void> addItemAsync(Item item) {
        return CompletableFuture.runAsync(() -> addItem(item));
    }

    public void showAllItemsInInventory() {
        items.forEach(i -> System.out.println("Предмет: " + i.getName() + " -" +
                " " +
                "Сила " + i.getPower()));
    }
}
