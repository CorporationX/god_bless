package school.faang.dotatwo;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Inventory {
    private static final String NAME_ENHANCED_ITEM = "Enchanted ";
    private static final int MAX_VALUE_MULTIPLIER_POWER = 2;
    private static final int MIN_VALUE_MULTIPLIER_POWER = 2;
    private static final Random RANDOM = new Random();

    private final List<Item> items = new CopyOnWriteArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item itemOnChest, Item itemOnShop) {
        int combinedPower = calculatePower(itemOnChest, itemOnShop);
        String combinedName = NAME_ENHANCED_ITEM + itemOnChest.name();
        return new Item(combinedName, combinedPower);
    }

    public void printInventory() {
        items.forEach(item -> log.info("Item - {}, power - {}", item.name(), item.power()));
    }

    public CompletableFuture<Item> getItemOnChest(Item item, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> item, executor);
    }

    public CompletableFuture<Item> getItemOnShop(Item item, ExecutorService executor) {
        return CompletableFuture.supplyAsync(() -> item, executor);
    }

    private int calculatePower(Item itemOnChest, Item itemOnShop) {
        return (itemOnChest.power() + itemOnShop.power())
                * (MIN_VALUE_MULTIPLIER_POWER + RANDOM.nextInt(MAX_VALUE_MULTIPLIER_POWER));
    }
}
