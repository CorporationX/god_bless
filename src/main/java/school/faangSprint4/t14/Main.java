package school.faangSprint4.t14;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        GameSystem gameSystem = new GameSystem();
        CompletableFuture<Void> future = gameSystem.getItemFromChest()
                .thenCombine(gameSystem.getItemFromShop(), (chestItem, shopItem) -> {
                    System.out.println("Both items received, ready to combine");
                    return new Object[]{chestItem, shopItem};
                })
                .thenCompose(items -> {
                    Item item1 = (Item) ((Object[]) items)[0];
                    Item item2 = (Item) ((Object[]) items)[1];
                    return gameSystem.combineItemsAsync(item1, item2);
                })
                .thenCompose(gameSystem::addItemToInventoryAsync);

        future.join();

        System.out.println("\nFinal inventory contents:");
        gameSystem.getInventory().getItems().forEach(System.out::println);
    }
}