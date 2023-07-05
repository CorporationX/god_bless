package faang.school.godbless.carry;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
         Inventory inventory = new Inventory();
         inventory.itemFromBox("first", 3)
                .thenCombine(inventory.itemFromShop("second", 4), inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item))).get();

        for(Item item : inventory.items){
            System.out.println("Предмет: " + item.getName());
            System.out.println("Сила предмате - " + item.getPower());
        }
    }
}
