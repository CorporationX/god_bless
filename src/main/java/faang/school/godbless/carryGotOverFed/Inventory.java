package faang.school.godbless.carryGotOverFed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        Item item = new Item();
        item.setName(firstItem.getName() + secondItem.getName());
        item.setPower(firstItem.getPower() + secondItem.getPower());
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
                Thread.sleep(2000);
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
        inventory.getFromChest()
                .thenCombine(inventory.buy(), inventory::combineItems)
                .thenCompose(item-> CompletableFuture.runAsync(()->inventory.addItem(item)))
                .thenRun(()-> System.out.println(inventory.items)).join();

//        CompletableFuture<Item> fromChest = inventory.getFromChest();
//        CompletableFuture<Item> bought = inventory.buy();

        //Combine
//        CompletableFuture.allOf(fromChest, bought)
//                .thenApply(v-> inventory.combineItems(fromChest.join(), bought.join()))
//                .thenAccept(item-> System.out.println("Combined item: "+ item));

//        fromChest.thenCombine(bought, (result1, result2) -> inventory.combineItems(result1, result2)).thenAccept(item -> System.out.println("Combined item: " + item));

//        fromChest.thenCombine(bought, inventory::combineItems).thenAccept(item -> System.out.println("Combined item: " + item));

        //Compose
//        CompletableFuture<Item> combined = fromChest.thenCombine(bought,inventory::combineItems);
//        CompletableFuture.runAsync(()->inventory.addItem(combined.join()));
//        combined.thenCompose(item-> CompletableFuture.runAsync(()->inventory.addItem(item)));
//        CompletableFuture<Item> combined = fromChest.thenCombine(bought,inventory::combineItems)
//                .thenCompose(item->CompletableFuture.supplyAsync(()->{
//                    inventory.addItem(item);
//                    return item;
//                }));
//        fromChest.thenCombine(bought,inventory::combineItems)
//                .thenCompose(item->CompletableFuture.runAsync(()->inventory.addItem(item)));
    }
}
