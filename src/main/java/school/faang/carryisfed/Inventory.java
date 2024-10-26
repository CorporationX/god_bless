package school.faang.carryisfed;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Inventory {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Добавлен предмет в инвентарь: " + item.getName() + " с силой: " + item.getPower());
    }

    public Item combineItems(Item firstItem, Item secondItem) {
        int combinedPower = firstItem.getPower() + secondItem.getPower();
        Item combinedItem = new Item("Новый предмет", combinedPower);
        System.out.println("Создан новый предмет: " + combinedItem.getName() + " с силой: " + combinedItem.getPower());
        return combinedItem;
    }
}
