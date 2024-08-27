package faang.school.godbless.dota2;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Inventory {
    private final List<Item> items = new LinkedList<>();

    public synchronized void addItem(Item item) {
        items.add(item);
    }

    public synchronized Item combineItems(Item item1, Item item2) {
        return new Item(
                "CombinationOf" + item1.getName() + "And" + item2.getName(),
                item1.getPower() + item2.getPower());
    }
}
