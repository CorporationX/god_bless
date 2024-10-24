package school.faang.carry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    static Inventory inventory = new Inventory();

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() ->
                new Item("Меч Кладенец", 10));
    }

    public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() ->
                new Item("Щит", 5));
    }

    public void combineItems() {
        CompletableFuture<Item> itemFromChest = getItemFromChest();
        CompletableFuture<Item> itemFromShop = getItemFromShop();

        itemFromChest.thenCombine(itemFromShop, ((item, item2) -> {
            log.info("Комбинируем предметы {} и {}", item.getName(), item2.getName());
            return inventory.combineItem(item, item2).join();
        })).thenCompose(newItem -> {
            inventory.addItemAsync(newItem);
            return null;
        });
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println();
        game.combineItems();
        System.out.println();
        inventory.showAllItemsInInventory();
    }
}
