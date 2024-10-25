package school.faang.Multithreading.sprint_4.CurryEat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Inventory {
    private final List<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        Item newItem =  item1.combineNewItem(item2);
        System.out.println("Создан новый предмет " + newItem);
        return newItem;
    }

    public void launchCombine(){
        DistributionItems distributionItems = new DistributionItems();

        distributionItems.getItemFromChest()
                .thenCombine(distributionItems.getItemFromStore(), (item1, item2) -> combineItems(item1,item2))
                .thenCompose(newItem -> CompletableFuture.runAsync(() -> addItem(newItem)))
                .join();
    }
}
