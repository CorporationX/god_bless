package school.faang.fourthStream.BJS2_38796;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Inventory {
    private final List<Item> items = Collections.synchronizedList(new ArrayList<>());

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        int totalPower = item1.getPower() + item2.getPower();
        return new Item("Combined Item" + totalPower, totalPower);
    }
}
