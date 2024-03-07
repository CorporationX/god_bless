package CarryOverFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) { items.add(item); }
    public static Item combineItems(Item item1, Item item2) {
        String newName = item1.getName() + " + " + item2.getName();
        int newPower = (int) (item1.getPower() + item2.getPower());
        return new Item(newName, newPower); }



    private CompletableFuture<Item>  getItem1FromBox() {
        CompletableFuture.supplyAsync (() -> new Item("Sword", 3));
    }

    private CompletableFuture<Item> getItem2FromGrocery() {

        CompletableFuture.supplyAsync (() ->new Item("Knife", 4));
    }


    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        CompletableFuture<Item> item1 = inventory.getItem1FromBox();
        CompletableFuture<Item> item2 = inventory.getItem2FromGrocery();

        item1.thenCombine(item2, Inventory::combineItems)
                .thenAccept(inventory::addItem)
                .join();
        System.out.println("В инвентарь упала шмотка " + inventory.items);
    }
}

