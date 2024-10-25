package school.faang.carryisfed;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        CompletableFuture<Item> firstItemFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Получение первого предмета из сундука...");
            return new Item("Sword", 15);
        });

        CompletableFuture<Item> secondItemFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Получение второго предмета из магазина...");
            return new Item("Shield", 25);
        });

        CompletableFuture<Item> combinedItemFuture = firstItemFuture.thenCombine(secondItemFuture, (firstItem, secondItem) -> {
            System.out.println("Комбинирование предметов...");
            return inventory.combineItems(firstItem, secondItem);
        });

        CompletableFuture<Void> finalFuture = combinedItemFuture.thenCompose(combinedItem ->
                CompletableFuture.runAsync(() -> inventory.addItem(combinedItem))
        );

        // Ожидание завершения всех операций
        finalFuture.join();

        System.out.println("\nИтоговый инвентарь:");
        inventory.getItems().forEach(item ->
                System.out.println("Предмет: " + item.getName() + " Сила: " + item.getPower())
        );
    }
}
