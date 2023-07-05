package faang.school.godbless.carry;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public static Item combineItems(Item item1, Item item2) {
        System.out.println("Комбинируем предметы: " + item1.getName() + " + " + item2.getName());
        String combinedName = item1.getName() + "-" + item2.getName();
        int combinedPower = item1.getPower() + item2.getPower();
        return new Item(combinedName, combinedPower);
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Предмет добавлен в инвентарь: [" + item.getName() + "]");
    }
}
