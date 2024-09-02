package faang.school.godbless.BJS2_24931;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Game {
    private static Random random = new Random();

    public static Item getFromChest() {
        try {
            Thread.sleep(1000L * (1 + random.nextInt(5)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Item("Sword", 100);
    }

    public static Item buyFromShop() {
        try {
            Thread.sleep(1000L * (1 + random.nextInt(5)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Item("MagicPowerStone", 30);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CompletableFuture<Item> getFromChestResult = CompletableFuture.supplyAsync(Game::getFromChest);
        CompletableFuture<Item> buyFromShopResult = CompletableFuture.supplyAsync(Game::buyFromShop);
        getFromChestResult.thenCombineAsync(buyFromShopResult, inventory::combineItem)
                .thenAccept(inventory::addItem).join();

        System.out.println(inventory.getItems());
    }

}
