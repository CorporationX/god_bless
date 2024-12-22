package school.faang.task_50675;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Item> firstTask = inventory.getItemFromChest(executorService);
        CompletableFuture<Item> secondTask = inventory.getItemFromShop(executorService);

        CompletableFuture<Void> allTasks = inventory.thenDoCombineCompose(firstTask, secondTask);
        allTasks.join();

        System.out.println(inventory.getItems());
        if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
            executorService.shutdown();
        }
    }
}