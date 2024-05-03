package faang.school.godbless.BJS2_6145;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class Inventory {
    private final List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItem(Item item1, Item item2) {
        Item item = new Item();
        item.setName(item1.getName() + "-" + item2.getName());
        item.setPower(item1.getPower() + item2.getPower());
        return item;
    }

    public CompletableFuture<Item> getFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Sword");
            item.setPower(10);
            return item;
        });
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Axe");
            item.setPower(20);
            return item;
        });
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> fromShop = inventory.buy();

        fromShop.thenCombine(fromChest, inventory::combineItem).
                thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).join();

        System.out.println(inventory.getItems());
    }
}
