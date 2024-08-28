package carry;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public synchronized void addItem(@NonNull Item item) {
        items.add(item);
        log.info(item.getName() + " added to hero inventory");
    }

    public Item combineItem(@NonNull Item item1, Item item2) {
        log.info("Items combined");
        return new Item("Super " + item1.getName().split(" ")[0] +
                " " + item2.getName().split(" ")[0],
                item1.getPower() + item2.getPower());
    }

    public void printAllItems() {
        items.forEach(i -> log.info(i.toString()));
    }
}
