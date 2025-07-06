package school.faang.bjs2_82718;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Inventory extends SpaceItem {
    public Inventory(@NonNull List<Item> items) {
        super(items);
    }

    public void addItem(Item item) {
        log.info("Предмет {} добавлен в инвентарь", item.getName());
        items.add(item);
    }

    public Item combineItems(Item item1, Item item2) {
        log.info("Создается комбинированный предмет");
        return new Item(
                item1.getName() + " | " + item2.getName(),
                item1.getPower() + item2.getPower()
        );
    }
}
