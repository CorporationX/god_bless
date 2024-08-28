package faang.school.godbless.FeedCarry;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> futureMidas = getItemFromStash();
        CompletableFuture<Item> futureRapier = buyItem();

        futureMidas.join();
        futureRapier.join();

        CompletableFuture<Item> futureCombo = futureRapier.thenCombine(futureMidas, inventory::combineItems);

        CompletableFuture<Void> addItem = futureCombo.thenCompose(item -> {
            return CompletableFuture.runAsync(() -> inventory.addItem(item));
        });

        addItem.join();
        System.out.println("скрафтили нереальный предмет!");
        System.out.println(inventory.getItems().get(0).getName());
        System.out.println(inventory.getItems().get(0).getPower());
    }

    public static CompletableFuture<Item> getItemFromStash() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("ждём куру с мидасом");
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("оооп ща фарм пойдет мидас приехал");
            return new Item("midas", 5);
        });
    }

    public static CompletableFuture<Item> buyItem() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("посылаем куру в потайнуху");
                Thread.sleep(new Random().nextInt(5) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("прикупились приподнялись");
            return new Item("divine rapier", 10);
        });
    }
}
