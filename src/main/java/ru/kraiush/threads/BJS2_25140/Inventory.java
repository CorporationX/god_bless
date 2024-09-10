package ru.kraiush.threads.BJS2_25140;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Inventory {

    List<Item> listitems;

    public CompletableFuture<List<Item>> addItem(List<Item> list, CompletableFuture<Item> futureItem) {
        return futureItem.thenCompose(item ->
                CompletableFuture.supplyAsync(() -> {
                    list.add(item);
                    return list;
                }));
    }

    public CompletableFuture<Item> combineItems(Item item1, Item item2) {

        return CompletableFuture.supplyAsync(() -> item1)
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> item2), (i1, i2) -> {
                    return new Item("{" +i1.getName() + "} united with {" + i2.getName() + "}", i1.getPower() + i2.getPower());
                });
    }
}
