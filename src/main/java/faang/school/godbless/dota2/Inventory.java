package faang.school.godbless.dota2;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        return new Item(item1.getName() + " " + item2.getName(),
                item1.getPower() + item1.getPower());
    }
}
