package school.faang.bjs2_94777;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

@Slf4j
public class Inventory {
    private final List<Item> items = new CopyOnWriteArrayList<>();

    public CompletableFuture<Item> addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Предмет не может быть пустым");
        }
        return CompletableFuture.supplyAsync(() -> {
            items.add(item);
            log.info("Коментатор - {}: Предмет {} попал в инвентарь игрока!",
                    Thread.currentThread().getName(), item.getName());
            return item;
        });
    }

    public void combineItems(CompletableFuture<Item> item1, CompletableFuture<Item> item2, ExecutorService executor) {
        CompletableFuture<Item> result = item1.thenCombineAsync(item2, (itemOne, itemTwo) -> {
            Item newitem = new Item(itemOne.getName() + itemTwo.getName(),
                    itemOne.getPower() + itemTwo.getPower());
            log.info("Коментатор - {}: В инвентаре объеденились два предмета и образовали {}, силой {}",
                    Thread.currentThread().getName(), newitem.getName(), newitem.getPower());
            return newitem;
        }, executor);
        result.thenComposeAsync(this::addItem, executor);
    }
}
