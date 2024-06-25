package faang.school.godbless.future.carryOut;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("knife", 2));

        Story story = new Story(List.of(
                new Item("knife", 5),
                new Item("defense", 10),
                new Item("sword", 15)
        ));

        CompletableFuture<Item> itemFromInventory = inventory.getItemFromInventory();
        CompletableFuture<Item> itemFromStore = inventory.buyItemFromStory(story);

        itemFromInventory.thenCombine(itemFromStore, inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItem(item)));
    }
}
