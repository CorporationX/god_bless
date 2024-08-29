package faang.school.godbless.carry;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Getter
public class Inventory {
    private final List<Item> items = new ArrayList<>();
    private final Chest chest = new Chest();
    private final Shop shop = new Shop();


    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        log.info("Зашли в combineItems - " + item1.getName() + " - " + item2.getName());
        Item item = new Item(item1.getName() + " + " + item2.getName(), item1.getPower() + item2.getPower());
        log.info(Thread.currentThread().getName() + " новое оружие из combineItems - " + item);
        return item;
    }

    public CompletableFuture<Item> getItemFromChest() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            log.info(Thread.currentThread().getName() + " выходит из getItemFromChest с " + chest.getItems().get(0));
            return chest.getItems().get(0);
        });
    }

   public CompletableFuture<Item> getItemFromShop() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            log.info(Thread.currentThread().getName() + " выходит из getItemFromShop с " + shop.getItems().get(1));
            return shop.getItems().get(1);
        });
   }
}
