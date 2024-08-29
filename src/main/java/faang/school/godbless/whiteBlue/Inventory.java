package faang.school.godbless.whiteBlue;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public static Item combineItems(Item item1, Item item2) {
        return new Item(item1.getName() + " " + item2.getName(),
                item1.getPower() + item2.getPower());
    }
}
