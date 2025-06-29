package school.faang.module1.bjs2_82746;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Inventory {

    private final ExecutorService executor;
    private final List<Item> items = new ArrayList<>();
    private final Object lock = new Object();

    private static final long CHEST_DELAY_MS = 1000;
    private static final long SHOP_DELAY_MS = 1500;
    private static final int CHEST_MIN_POWER = 10;
    private static final int CHEST_MAX_POWER = 30;
    private static final int SHOP_MIN_POWER = 20;
    private static final int SHOP_MAX_POWER = 40;

    public void addItem(Item item) {
        synchronized (lock) {
            items.add(item);
            log.info("Item {} добавлен в инвентарь", item.getName());
        }
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        String combinedName = firstItem.getName() + "-" + secondItem.getName();
        int combinedPower = firstItem.getPower() + secondItem.getPower();
        Item newItem = new Item(combinedName, combinedPower);
        log.info("Создан новый комбинированный предмет {}: ", newItem);
        return newItem;
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(CHEST_DELAY_MS);
            Item item = new Item("ChestItem", ThreadLocalRandom.current().nextInt(CHEST_MIN_POWER, CHEST_MAX_POWER));
            log.info("Получен предмет из сундука: {}", item);
            return item;
        }, executor);
    }

    public CompletableFuture<Item> getFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(SHOP_DELAY_MS);
            Item item = new Item("ShopItem", ThreadLocalRandom.current().nextInt(SHOP_MIN_POWER, SHOP_MAX_POWER));
            log.info("Куплен предмет в магазине: {}", item);
            return item;
        }, executor);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public List<Item> getItems() {
        synchronized (lock) {
            return new ArrayList<>(items);
        }
    }
}