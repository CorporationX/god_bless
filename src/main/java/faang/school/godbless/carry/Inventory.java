package faang.school.godbless.carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Inventory {
    List<Item> items = new ArrayList<>();

    public void addItem(CompletableFuture<Item> item){
        try {
            items.add(item.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public CompletableFuture<Item> combineItems(Item first, Item second){
        return CompletableFuture.supplyAsync(() -> new Item(first.getName()+ "-" + second.getName(),
                Integer.sum(first.getPower(), second.getPower())));
    }

    public CompletableFuture<Item> itemFromBox(String name, int power){
        return CompletableFuture.supplyAsync(() -> new Item(name, power));
    }

    public CompletableFuture<Item> itemFromShop(String name, int power){
        return CompletableFuture.supplyAsync(() -> new Item(name, power));
    }
}
