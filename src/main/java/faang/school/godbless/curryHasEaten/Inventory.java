package faang.school.godbless.curryHasEaten;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final List<Item> itemsChest = new ArrayList<>();
    private final List<Item> itemsBuy = new ArrayList<>();

    Random random = new Random();

    public String addItemChest(Item item) {
        itemsChest.add(item);
        return item.getName() + "добавлен";
    }

    public void addItemBuy(Item item) {
        itemsBuy.add(item);
    }

    public Item combine(Item first, Item second) {
        Item item = new Item("", 0);
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
            return itemsChest.get(random.nextInt(1));
        });
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return itemsBuy.get(random.nextInt(1));
        });
    }
}