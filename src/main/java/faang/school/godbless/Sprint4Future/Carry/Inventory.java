package faang.school.godbless.Sprint4Future.Carry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItem(Item item1, Item item2) {
        Item newItem = new Item(item1.getName() + item2.getName()
                , item1.getPower() + item2.getPower());
        return newItem;
    }
}
