package faang.school.godbless.fourthsprint.carry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Added to inventory: " + item);
    }

    public Item combineItems(Item item1, Item item2) {
        String combinedName = item1.getName() + " + " + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();
        return new Item(combinedName, combinedPower);
    }
}
