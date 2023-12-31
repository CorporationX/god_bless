package faang.school.godbless.carry;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        extractingBox(inventory);
        extractingShop(inventory);
        CompletableFuture<Item> itemFromBox = inventory.getItemFromBox();
        CompletableFuture<Item> itemFromShop = inventory.getItemFromShop();
        CompletableFuture<Void> future =CompletableFuture.runAsync(()-> inventory.combineItems(itemFromBox.join(), itemFromShop.join()).thenCompose(item -> {
            inventory.addItem(item);
            return null;
        }));
        future.join();
        System.out.println(inventory.getItems());
    }
    private static void extractingShop(Inventory inventory) {
        inventory.getItemsInShop().add(new Item("sword", 10));
        inventory.getItemsInShop().add(new Item("shield", 5));
        inventory.getItemsInShop().add(new Item("armor", 20));
    }

    private static void extractingBox(Inventory inventory) {
        inventory.getItemsInBox().add(new Item("sword", 10));
        inventory.getItemsInBox().add(new Item("shield", 5));
        inventory.getItemsInBox().add(new Item("armor", 20));
    }
}
