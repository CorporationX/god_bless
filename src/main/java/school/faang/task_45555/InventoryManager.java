package school.faang.task_45555;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import school.faang.task_45555.entity.Item;
import school.faang.task_45555.entity.Character;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InventoryManager {
    private static final Logger log = LoggerFactory.getLogger(InventoryManager.class);

    public void addItem(Character character, Item item, Consumer<Item> action) {
        List<Item> items = character.getInventory();
        items.add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        List<Item> items = character.getInventory();
        items.stream().filter(filter).forEach(item -> log.info("Removing item: {}", item.getName()));
        items.removeIf(filter);
        log.info("Successfully removed items from inventory");
    }

    public Character updateItem(Character character, Predicate<Item> filter, Function<Item, Item> action) {
        List<Item> items = character.getInventory();
        Stream<Item> itemsAfterFilter = items.stream()
                .filter(filter.negate());
        Stream<Item> trueItemsAfterFilter = items.stream()
                .filter(filter)
                .map(action);
        return new Character(character.getName(), Stream.concat(itemsAfterFilter, trueItemsAfterFilter).toList());
    }
}
