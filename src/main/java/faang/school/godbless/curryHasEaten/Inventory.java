package faang.school.godbless.curryHasEaten;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void add(Item item) {
        items.add(item);
    }

    public Item combine(Item first, Item second) {
        Item item = new Item();
        item.setName(first.getName() + " " + second.getName()
                + LocalDateTime.now().format(dateTimeFormatter) + " ");
        item.setPower(first.getPower() + second.getPower());
        return item;
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Sword " + LocalDateTime.now().format(dateTimeFormatter));
            item.setPower(10);
            return item;
        });
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Spear " + LocalDateTime.now().format(dateTimeFormatter));
            item.setPower(20);
            return item;
        });
    }
}