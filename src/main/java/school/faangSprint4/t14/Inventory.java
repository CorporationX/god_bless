package school.faangSprint4.t14;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {
    private final List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added item to inventory: " + item);
    }

    public Item combineItems(Item item1, Item item2) {
        int combinedPower = item1.power() + item2.power();
        String combinedName = item1.name() + "_" + item2.name();
        return new Item(combinedName, combinedPower);
    }
}