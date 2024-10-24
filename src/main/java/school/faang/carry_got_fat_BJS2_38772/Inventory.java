package school.faang.carry_got_fat_BJS2_38772;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Inventory {
    private List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        return new Item(item1.getName() + " Strengthen",
                item1.getPower() + item2.getPower());
    }
}