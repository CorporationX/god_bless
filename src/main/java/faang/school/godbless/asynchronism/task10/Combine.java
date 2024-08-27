package faang.school.godbless.asynchronism.task10;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Combine {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Butterfly", 150));
        inventory.addItem(new Item("Mjolnir", 120));
        inventory.addItem(new Item("Heart of Tarrasque", 100));

        Shop shop = new Shop();
        shop.addItem(new Item("Glimmer Cape", 50));
        shop.addItem(new Item("Force Staff", 80));
        shop.addItem(new Item("Mekansm", 70));
        ExecutorService service = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(inventory::getItem, service)
                .thenCombineAsync(CompletableFuture.supplyAsync(shop::getItem, service),
                        Combine::combineItems, service)
                .thenComposeAsync(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)), service);
        voidCompletableFuture.join();
        service.shutdown();
        inventory.getItems().forEach(System.out::println);
    }

    private static Item combineItems(Item firstItem, Item secondItem) {
        return new Item(firstItem.getName() + secondItem.getName(),
                firstItem.getPower() + secondItem.getPower());
    }
}
