package school.faang.task50707;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Inventory {
    private static final int MAX_SIZE_INVENTORY = 9;

    private final List<Item> items = new ArrayList<>();

    private void printAddedItem(Item item) {
        log.info("Был добавлен новый предмет {}", item);
    }

    public synchronized void addItem(Item item) {
        Objects.requireNonNull(item);

        if (item.isCollectable()) {
            if (items.stream().anyMatch(Item::isCollectable)) {
                CompletableFuture<Item> buyItem = CompletableFuture.supplyAsync(() -> item);
                CompletableFuture<Item> oldItem = CompletableFuture.supplyAsync(() ->
                        items.stream().filter(Item::isCollectable).findFirst().get());

                try {
                    Item newItem = buyItem.thenCombine(oldItem, this::combineItems).get();
                    printAddedItem(newItem);
                    return;
                } catch (InterruptedException | ExecutionException e) {
                    log.error("Произошла ошибка при добавлении предмета", e);
                }
            }
        }

        if (items.size() > MAX_SIZE_INVENTORY) {
            log.error("Количество предметов в инвентаре не должно превышать {}", MAX_SIZE_INVENTORY);

        } else {
            items.add(item);
            printAddedItem(item);
        }
    }

    public synchronized Item combineItems(Item buyItem, Item oldItem) {
        items.remove(oldItem);
        log.info("{} был удалён, так как он был скомбинирован с {}", oldItem.name(), buyItem.name());
        return new Item("newItem", buyItem.power() + buyItem.power(), false);
    }
}
