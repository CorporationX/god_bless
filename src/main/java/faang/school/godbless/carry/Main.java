package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Item[] itemArray = {new Item("item1", 10),
                new Item("item2", 18),
                new Item("item3", 7),
                new Item("item4", 5)};

        CopyOnWriteArrayList<Item> items = new CopyOnWriteArrayList<>(itemArray);

        Inventory inventory = new Inventory(items);

        CompletableFuture<Item> futureItem1 = CompletableFuture.supplyAsync(inventory::getRandomItem);
        CompletableFuture<Item> futureItem2 = CompletableFuture.supplyAsync(inventory::getRandomItem);

        if (futureItem1.isDone() && futureItem2.isDone()){
            CompletableFuture<Void> combinedItemFuture = futureItem1
                    .thenCombine(futureItem2, inventory::combineItems)
                    .thenCompose(inventory::addItem);
            combinedItemFuture.join();
        }

        CompletableFuture.allOf(futureItem1,futureItem2).join();

        inventory.getItems().forEach(System.out::println);
    }
}
