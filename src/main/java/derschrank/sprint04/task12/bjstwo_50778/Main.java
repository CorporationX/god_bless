package derschrank.sprint04.task12.bjstwo_50778;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNTS_ITEMS_IN_SHOP = 100;
    private static final int COUNTS_ITEMS_IN_INVENTORY = 50;
    private static final int DELAY_FOR_COMBINE_PROCESS_MILLIS = 1000;

    public static void main(String[] args) {
        Inventory unit = new Inventory();
        ProviderItemsInterface shop = new Shop();

        Service.fillItemsInProvider(shop, COUNTS_ITEMS_IN_SHOP);
        System.out.println("\nSHOP HAS ITEMS: \n" + shop.getListOfItems());

        for (int i = 0; i < COUNTS_ITEMS_IN_INVENTORY; i++) {
            unit.buyItem(
                    shop,
                    Service.RND.nextInt(shop.getCountOfItems())
            );
        }

        System.out.printf("%nNOW INVENTORY HAS %d ITEMS:%n%s%n", unit.getCountOfItems(), unit.getListOfItems());
        System.out.printf("%nNOW SHOP HAS %d ITEMS:%n%s%n", shop.getCountOfItems(), shop.getListOfItems());

        System.out.println("\nNOW WORKSHOP WITH ITEMS FROM SHOP AND INVENTORY: \n" + shop.getListOfItems());
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        int originalCountOfItems = unit.getCountOfItems();
        for (int i = 0; i < originalCountOfItems; i++) {
            CompletableFuture<Item> futFromShop = CompletableFuture.supplyAsync(() -> shop.getItem(0).get());
            CompletableFuture<Item> futFromInventory = CompletableFuture.supplyAsync(() -> unit.getItem(0).get());
            futures.add(
                    futFromShop
                            .thenCombine(futFromInventory, unit::combineItems)
                            .thenCompose(item -> CompletableFuture.supplyAsync(() -> {
                                unit.addItem(item);
                                return item;
                            }))
                            .thenAccept(System.out::println)
                            .thenRun(() -> Service.toSleep(DELAY_FOR_COMBINE_PROCESS_MILLIS))
            );
        }

        futures.forEach(CompletableFuture::join);

        System.out.printf("%nNOW INVENTORY HAS %d ITEMS:%n%s%n", unit.getCountOfItems(), unit.getListOfItems());
        System.out.printf("%nNOW SHOP HAS %d ITEMS:%n%s%n", shop.getCountOfItems(), shop.getListOfItems());
    }
}
