package sprint5.dota;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Dota {
    private static final Inventory INVENTORY = new Inventory();

    public static void main(String[] args) {
        String characterName = "Oleg";
        CompletableFuture<Item> itemFromChest = INVENTORY.getItemFromChest(characterName);
        CompletableFuture<Item> itemFromShop = INVENTORY.getItemFromShop(characterName);
        Item item;

        try {
            item = INVENTORY.combineItem(itemFromChest, itemFromShop).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(item);
    }
}
