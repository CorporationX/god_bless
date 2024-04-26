package faang.school.godbless.Async.Carry;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2){
        String combinedName = item1.getName() + " + " + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();
        return new Item(combinedName, combinedPower);
    }

    public CompletableFuture<Item> getFromChest(int time, String name, int power){
        return newObject(time, name, power);
    }

    public CompletableFuture<Item> buy(int time, String name, int power) {
        return newObject(time, name, power);
    }

    public CompletableFuture<Item> newObject(int time, String name, int power){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item(name, power);
        });
    }
}

