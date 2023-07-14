package Sprint_4_1_Task14;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public Item combineItems(Item itemOne, Item itemTwo){
        String name = itemOne.getName() + "&" + itemTwo.getName();
        int power = itemOne.getPower() + itemTwo.getPower();
        return new Item(name, power);
    }
    public CompletableFuture<Item> getItems(Item item){
        return CompletableFuture.supplyAsync(() -> item);
    }
    public void assignPower(Item itemOne, Item itemTwo){
        CompletableFuture<Item> itemCompletableFuture = getItems(itemOne);
        CompletableFuture<Item> itemTwoCompletableFuture = getItems(itemTwo);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(itemCompletableFuture, itemTwoCompletableFuture);
        voidCompletableFuture
                .thenCompose(d -> itemCompletableFuture.thenCombine(itemTwoCompletableFuture, this::combineItems))
                .thenAccept(this::addItem)
                .join();
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item itemOne = new Item("item1", 1);
        Item itemTwo = new Item("item2", 2);
        inventory.assignPower(itemOne, itemTwo);
        System.out.println(inventory.items);
    }
}
