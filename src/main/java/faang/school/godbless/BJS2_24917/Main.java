package faang.school.godbless.BJS2_24917;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new ArrayList<>());

        Item.getItemFromChest()
                .thenCombine(Item.getItemFromChest(), Item::combineItems)
                .thenCompose(combinedItemFuture -> CompletableFuture.runAsync(() -> inventory.addItem(combinedItemFuture.join())))
                .join();

        System.out.println(inventory);
    }
}
