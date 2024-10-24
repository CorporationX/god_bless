package school.faang.fourthStream.BJS2_38796;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Combiner combiner = new Combiner();
        Inventory inventory = new Inventory();

        combiner.getItemFromChest()
                .thenCombine(combiner.getItemFromShop(),
                        (itemFromChest, itemFromShop) -> combiner.combineItems(itemFromChest, itemFromShop, inventory))
                .thenCompose(combinedItemFuture ->
                        combinedItemFuture.thenApplyAsync(combinedItem -> {
                            combiner.addItemToInventoryAsync(combinedItem, inventory).join();
                            return combinedItem;
                        }))
                .thenRun(() -> log.info("Inventory: {}", inventory.getItems()))
                .join();
    }
}
