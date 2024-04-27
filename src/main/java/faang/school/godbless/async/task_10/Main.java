package faang.school.godbless.async.task_10;

import faang.school.godbless.async.task_10.model.Inventory;
import faang.school.godbless.async.task_10.model.Item;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Item fromChest = new Item("лосe", 17);
        Item fromShop = new Item("лев", 4);
        CompletableFuture<Item> futureFromChest = inventory.getItemFromChest(fromChest);
        CompletableFuture<Item> futureFromShop = inventory.buyItemFromShop(fromShop);
        System.out.println();
        inventory.combineItemsFromChestAndShop(futureFromChest, futureFromShop);
    }
}