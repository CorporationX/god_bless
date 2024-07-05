package faang.school.godbless.carry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items = new ArrayList<>();
    public void addItem(Item item) {
        items.add(item);
    }
    public Item combineItems(Item item1, Item item2){
        Item result = new Item();
        result.setName(item1.getName()+item2.getName());
        result.setPower(item1.getPower()+item2.getPower());
        return result;
    }
    public CompletableFuture<Item> getItemFromChest( ){
        Random random = new Random();
        return CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           return items.get(random.nextInt(items.size()));
        });
    }

    public CompletableFuture<Item> buyItem(String itemName ) {
        Random random = new Random();
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1234);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Item(itemName, random.nextInt());
        });
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item("item1",10));
        inventory.addItem(new Item("item2",20));
        inventory.addItem(new Item("item3",30));

        CompletableFuture<Item> chestItem = inventory.getItemFromChest();
        CompletableFuture<Item> shopItem = inventory.buyItem("Dagger");
        chestItem.thenCombine(shopItem,inventory::combineItems)
                .thenCompose(item -> CompletableFuture.runAsync(()->inventory.addItem(item)));

    }
}
