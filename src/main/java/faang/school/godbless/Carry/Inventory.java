package faang.school.godbless.Carry;

import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.concurrent.TimeUnit.SECONDS;

@ToString
@Slf4j
public class Inventory {
    private final Map<Item, Integer> items = new HashMap<>();

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> fromStore = inventory.getFromStore();

        fromChest.thenCombine(fromStore, inventory::combineItem)
                .thenCompose(item -> CompletableFuture.runAsync(() -> {
                    if (item.isPresent()) {
                        Item combined = item.get();
                        log.info("{} combined", combined);
                        inventory.addItem(combined);
                    } else {
                        log.info("Combination failed, item not created");
                    }
                })).join();


    }

    public void addItem(Item item) {
        items.compute(item, (key, var) -> var == null ? 1 : var + 1);
    }

    public Optional<Item> combineItem(@NonNull Item... itemsToCombine) {
        List<Item> itemsList = Arrays.asList(itemsToCombine);
        if (!checkAvailabilityOfItems(itemsList)) {
            return Optional.empty();
        }
        Item resultItem = itemsList.get(0);
        decreaseByOneOrRemoveItemsFromInventory(itemsList);
        resultItem.setName(concatenateItemsName(itemsList));
        resultItem.setPower(sumItemsPower(itemsList));
        return Optional.of(resultItem);

    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            sleeeeeeping(1);
            Item item = new Item("FireBowl", 10);
            log.info("{} getFromChest", item);
            addItem(item);
            return item;
        });
    }

    public CompletableFuture<Item> getFromStore() {
        return CompletableFuture.supplyAsync(() -> {
            sleeeeeeping(2);
            Item item = new Item("WaterSpear", 15);
            log.info("{} getFromStore", item);
            addItem(item);
            return item;
        });
    }

    private void sleeeeeeping(int seconds) {
        try {
            SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
    }

    public void decreaseByOneOrRemoveItemsFromInventory(@NonNull List<Item> itemsToBeRemoved) {
        itemsToBeRemoved.forEach(item -> items.computeIfPresent(item, (key, var) -> var > 1 ? var - 1 : null));
    }

    public Boolean checkAvailabilityOfItems(@NonNull List<Item> itemsToBeChecked) {
        return itemsToBeChecked.stream()
                .allMatch(item -> items.containsKey(item) && items.get(item) > 0);
    }

    public String concatenateItemsName(@NonNull List<Item> itemsList) {
        return itemsList.stream()
                .map(Item::getName)
                .collect(Collectors.joining("_"));
    }

    public double sumItemsPower(@NonNull List<Item> itemsList) {
        return itemsList.stream()
                .mapToDouble(Item::getPower)
                .sum();
    }
}
