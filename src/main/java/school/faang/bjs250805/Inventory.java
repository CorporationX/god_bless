package school.faang.bjs250805;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Getter
@RequiredArgsConstructor
public class Inventory {
    private static final long PROCESS_TIME = 1000;
    private final Random random = new Random();
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    private Item combineItems(Item item1, Item item2) {
        return new Item(item1.name() + " + " + item2.name(), item1.power() + item2.power());
    }

    public CompletableFuture<Item> getFirstItemFromBox() {
        return CompletableFuture.supplyAsync(() -> {
            getItemProcess();
            log.info("The item got from the box");
            return new Item("Item1", random.nextInt());
        });
    }

    public CompletableFuture<Item> getSecondItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            getItemProcess();
            log.info("The item got from the shop");
            return new Item("Item2", random.nextInt());
        });
    }

    public CompletableFuture<Item> combiningItems() {
        return getFirstItemFromBox().thenCombine(getSecondItemFromShop(), this::combineItems)
                .thenCompose(newItem -> {
                    addItem(newItem);
                    return CompletableFuture.completedFuture(newItem);
                });
    }

    private void getItemProcess() {
        try {
            Thread.sleep(PROCESS_TIME);
        } catch (InterruptedException e) {
            log.error("The tread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}