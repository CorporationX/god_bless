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

    public Item combineItem(@NonNull Item item1, @NonNull Item item2) {
        String itemName = "Super " + item1.getName().split(" ")[0] +
                " " + item2.getName().split(" ")[0];
        int itemPower = item1.getPower() + item2.getPower();
        Item item = new Item(itemName, itemPower);
        log.info("Items combined");
        return item;
    }

    public void printAllItems() {
        items.forEach(i -> log.info(i.toString()));
    }
}
