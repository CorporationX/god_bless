package faang.school.godbless.multithreading_async.dota;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Getter
public class Inventory {
    private List<Item> items;
    private static final Random RANDOM = new Random();

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItem(Item firstItem, Item secondItem) {
        return new Item(firstItem.getName() + secondItem.getName(), firstItem.getPower() + secondItem.getPower());
    }

    public static CompletableFuture<Item> getFirstItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getItemsDota().get(RANDOM.nextInt(getItemsDota().size()));
        });
    }

    public static CompletableFuture<Item> getSecondItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return getItemsDota().get(RANDOM.nextInt(getItemsDota().size()));
        });
    }

    private static List<Item> getItemsDota() {
        return new ArrayList<>() {{
            add(new Item("Рапира", 330));
            add(new Item("Бабочка", 36));
            add(new Item("Палка", 1));
            add(new Item("Топор", 5));
            add(new Item("Дезолятор", 75));
        }};
    }
}
