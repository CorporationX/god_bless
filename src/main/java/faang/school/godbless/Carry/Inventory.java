package faang.school.godbless.Carry;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public static Item combineItems(Item item1, Item item2) {
        String combinedName = item1.getName() + " & " + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();

        return new Item(combinedName, combinedPower);
    }
}
