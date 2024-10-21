package school.BJS2_38819;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();

        Iventory iventory = new Iventory(items);

        CompletableFuture<Item> itemFromChest = iventory.getItemFromChest();
        CompletableFuture<Item> itemFromShop = iventory.getItemFromShop();
        CompletableFuture<Item> newItem = iventory.combineItems(itemFromChest,itemFromShop);
        iventory.addNewItem(newItem);

        System.out.println(iventory.getItems());
    }
}
