package faang.school.godbless.future.carryOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@AllArgsConstructor
@Data
public class Inventory {

    public static final int BUY_THREAD_SLEEP = 2000;
    public static final int GET_INVENTORY_THREAD_SLEEP = 1500;

    private final List<Item> items = new ArrayList<>();

    public void addItem(@NonNull Item item) {
        items.add(item);
    }

    public Item combineItems(@NonNull Item firstItem, @NonNull Item secondItem) {
        int totalPower = firstItem.getPower() + secondItem.getPower();
        return new Item(firstItem.getName() + " + " + secondItem.getName(), totalPower);
    }

    public CompletableFuture<Item> getItemFromInventory() {
        return CompletableFuture.supplyAsync(() -> {
            threadSleep(GET_INVENTORY_THREAD_SLEEP);
            return items.isEmpty() ? null : items.get(new Random().nextInt(items.size()));
        });
    }

    public CompletableFuture<Item> buyItemFromStory(Story story) {
        return CompletableFuture.supplyAsync(() -> {
            threadSleep(BUY_THREAD_SLEEP);
            return story.buyItem();
        });
    }

    private static void threadSleep(int millis) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(millis));
    }
}
