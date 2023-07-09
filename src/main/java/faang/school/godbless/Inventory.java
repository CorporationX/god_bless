package faang.school.godbless;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Data
public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
        System.out.println("Added item to inventory: " + item.getName());
    }

    public void combineItems(Item item1, Item item2){
        System.out.println("Combined items: " + item1.getName() + " and " + item2.getName());
        addItem(new Item(item1.getName() + ' ' + item2.getName(), item1.getPower() + item2.getPower()));
    }

}
