package faang.school.godbless.Multithreading.AsynchronismFutureCompletableFuture.task14_Carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        Item item = new Item();
        item.setName(item1.getName() + "+" + item2.getName());
        item.setPower(item1.getPower() + item2.getPower());
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
            item.setName("Sword");
            item.setPower(10);
            return item;
        });
    }

    public CompletableFuture<Item> buy() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Item item = new Item();
            item.setName("Spear");
            item.setPower(20);
            return item;
        });
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> fromChest = inventory.getFromChest();
        CompletableFuture<Item> bought = inventory.buy();

//        CompletableFuture.allOf(fromChest, bought)
//                .thenApply(v -> inventory.combineItems(fromChest.join(), bought.join()))
//                .thenAccept(item -> System.out.println("Combined item: " + item));
//
//        fromChest.thenCombine(bought, (r1, r2) -> inventory.combineItems(r1, r2))
//                .thenAccept(item -> System.out.println("Combined item" + item));

        fromChest.thenCombine(bought, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.add(item)));

    }
}
