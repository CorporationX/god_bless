package faang.school.godbless.sprint5.Multithreading_Async.task14_Carry;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> items= new ArrayList<>();

    public void addItems(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        Item result = new Item();
        result.setName(item1.getName() + " " + item2.getName());
        result.setPower(item1.getPower() + item2.getPower());
        return result;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "items=" + items +
                '}';
    }
}
