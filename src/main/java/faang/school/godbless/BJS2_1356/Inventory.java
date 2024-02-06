package faang.school.godbless.BJS2_1356;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combine(Item item1, Item item2) {
        String combineName = item1.getName() + " + " + item2.getName();
        int combinePower = item1.getPower() + item2.getPower();

        return new Item(combineName, combinePower);
    }
}