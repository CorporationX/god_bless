package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("Diadem", 2));

        CompletableFuture<Item> item1 = inventory.getFromInventory("Diadem");
        CompletableFuture<Item> item2 = inventory.getFromShop("Axe");
        inventory.combineItems(item1, item2).join();

        Item combinedItem = getFromFuture(inventory.getFromInventory("Diadem Axe"));
        inventory.shutdownAndAwaitExecution(5L);
        System.out.println("Combined item: " + combinedItem);
    }

    private static <T> T getFromFuture(Future<T> future) {
        try {
            return future.get(30L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
