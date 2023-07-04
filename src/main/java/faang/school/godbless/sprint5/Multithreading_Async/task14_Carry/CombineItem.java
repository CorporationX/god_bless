package faang.school.godbless.sprint5.Multithreading_Async.task14_Carry;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public class CombineItem {
    private Inventory inventory;

    public void putInTheInventory(Item item1, Item item2) {
        CompletableFuture<Item> itemCompletableFuture = combineItems(item1, item2);
        itemCompletableFuture
                .thenCompose(item -> CompletableFuture.runAsync(() -> inventory.addItems(item)));
    }

    public static void main(String[] args) {
        Inventory gabeInventory = new Inventory();
        CombineItem combineItem = new CombineItem(gabeInventory);
        Item item1 = new Item("Item 1", 100);
        Item item2 = new Item("Item 2", 120);

        combineItem.putInTheInventory(item1, item2);
        System.out.println(gabeInventory);
    }

    private CompletableFuture<Item> getItemFromChest(Item item) {
        return CompletableFuture.supplyAsync(() -> item);
    }

    private CompletableFuture<Item> getItemFromStore(Item item) {
        return CompletableFuture.supplyAsync(() -> item);
    }

    private CompletableFuture<Item> combineItems(Item item1, Item item2) {
        CompletableFuture<Item> itemFromChest = getItemFromChest(item1);
        CompletableFuture<Item> itemFromStore = getItemFromStore(item2);
        return itemFromChest.thenCombine(itemFromStore, inventory::combineItems);
    }
}
