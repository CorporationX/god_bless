package school.faang.sprint_4.task_50690;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Inventory {
    List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public synchronized void addItem(Item item) {
        if (item == null) {
            log.error("Предмет не может быть null");
            return;
        }
        items.add(item);
    }

    public static synchronized  Item combineItem(Item item1, Item item2) {
        String combinedName = "Combined Item";
        int sumPower = item1.power() + item2.power();
        return new Item(combinedName, sumPower);
    }
}
