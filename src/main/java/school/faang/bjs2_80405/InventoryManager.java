package school.faang.bjs2_80405;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> onAdd) {
        character.getInventory().add(item);
        onAdd.accept(item);
        log.info("Added item: {} to character: {}", item.getName(), character.getName());
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        List<Item> inventory = character.getInventory();
        boolean removedAny = inventory.removeIf(filter);
        if (removedAny) {
            log.info("Removed items from character: {}", character.getName());
        } else {
            log.info("No items matched the removal condition for character: {}", character.getName());
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                Item updatedItem = updater.apply(item);
                inventory.set(i, updatedItem);
                log.info("Updated item: {} with new value: {}", updatedItem.getName(), updatedItem.getValue());
                break;
            }
        }
    }
}
