package faang.school.godbless.Carry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public synchronized void addItem(Item item){
        items.add(item);
    }

    public synchronized Item combineItems(Item item1, Item item2){
        items.remove(item1);
        items.remove(item2);
        return new Item(item1.getName() + "-" + item2.getName(), item1.getPower() + item2.getPower());
    }
}
