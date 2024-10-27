package school.faang.carry_eated.main_code;

import java.util.ArrayList;
import java.util.List;

public class Invertory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item combineItem(Item item1, Item item2) {
        return new Item(item1.getName() + " " + item2.getName(), item1.getPower() + item2.getPower());
    }

    public void printAllItems() {
        items.forEach(i -> System.out.println("Предмет: " + i.getName() + " " + "Сила " + i.getPower()));
    }
}
