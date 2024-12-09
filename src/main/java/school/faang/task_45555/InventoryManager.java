package school.faang.task_45555;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_45555.entity.Item;
import school.faang.task_45555.entity.Character;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private static final Logger log = LoggerFactory.getLogger(InventoryManager.class);

    public void addItem(Character character, Item item, Consumer<Item> action) {
        List<Item> items = character.getInventory();
        items.add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        List<Item> items = character.getInventory();
        items.removeIf(filter);
        log.info("Successfully removed items from inventory");
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> update) {
        List<Item> items = character.getInventory();
        items.forEach(item -> {
            if (filter.test(item)) {
                items.set(items.indexOf(item), update.apply(item));
            }
        });
    }
}
