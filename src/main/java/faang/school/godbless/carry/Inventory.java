package faang.school.godbless.carry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

@Setter
@Getter
@AllArgsConstructor
public class Inventory {
    CopyOnWriteArrayList<Item> items;

    public CompletableFuture<Void> addItem(Item item) {

        return CompletableFuture.runAsync(() -> items.add(item));
    }

    public Item combineItems(Item item1, Item item2){
        Item combinedItem = new Item(
                item1.getName() + "/" + item2.getName(), item1.getPower() + item2.getPower());

        System.out.println("New item created: " + combinedItem.getName() + ", " + combinedItem.getPower());

        return combinedItem;
    }

    public Item getRandomItem(){
        Random random = new Random();
        int num = random.nextInt(items.size());

        return items.get(num);
    }
}
