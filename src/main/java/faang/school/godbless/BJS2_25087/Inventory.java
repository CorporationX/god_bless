package faang.school.godbless.BJS2_25087;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Inventory {

    private List<Item> items;

    public void addItem(Item item){
        items.add(item);
    }

    public Item combineItems(Item firstItem, Item secondItem){
        return new Item("Upgrade form of " + firstItem.getName() + secondItem.getName(), firstItem.getPower() + secondItem.getPower());
    }
}
