package faang.school.godbless.FeedCarry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    @Getter
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item, Item item2) {
        return new Item(item.getName() + "-" + item2.getName(), item.getPower() + item2.getPower());
    }
}
