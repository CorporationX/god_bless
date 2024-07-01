package faang.school.godbless.sprint2.dota2;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Evgenii Malkov
 */
@Getter
@Slf4j
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        log.info("Добавили Item: {}", item);
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        return new Item(
                firstItem.getName() + secondItem.getName(),
                firstItem.getPower() + secondItem.getPower());
    }

    @SneakyThrows
    public CompletableFuture<Item> getItemFromBox() {
        Thread.sleep(1000);
        return CompletableFuture.supplyAsync(() -> new Item("AA", 10));
    }

    @SneakyThrows
    public CompletableFuture<Item> getItemFromShop() {
        Thread.sleep(3000);
        return CompletableFuture.supplyAsync(() -> new Item("BB", 20));
    }
}
