package school.faang.bjs270086;


import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;


@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, BiConsumer<Character, Item> additionalAction) {
        if (character == null || item == null) {
            log.error("Character[{}] or item[{}] not provided.", character == null, item == null);
            return;
        }

        if (character.getInventory().contains(item)) {
            log.info("Item [{}] already in inventory [{}].", item.getName(), character.getName());
            return;
        }

        character.getInventory().add(item);
        if (additionalAction == null) {
            log.info("Additional action not specified, character [{}], item [{}]", character.getName(), item.getName());
            return;
        }
        additionalAction.accept(character, item);
    }

    public void removeItems(Character character, Predicate<Item> filter) {
        if (character == null || filter == null) {
            log.error("Character[{}] or filter[{}] not provided.", character == null, filter == null);
            return;
        }

        List<Item> filteredItems = character.getInventory().stream().filter(filter).toList();
        if (filteredItems.isEmpty()) {
            log.info("No one item is removed: {}.", character.getName());
            return;
        }
        character.getInventory().removeAll(filteredItems);
    }

    public void updateItems(Character character, Predicate<Item> filter, Consumer<Item> updater) {
        if (character == null || filter == null || updater == null) {
            log.error("Character[{}], filter[{}] or updater [{}] not provided.",
                    character == null, filter == null, updater == null);
            return;
        }

        List<Item> filteredItems = character.getInventory().stream().filter(filter).toList();
        if (filteredItems.isEmpty()) {
            log.info("No one item is updated: {}.", character.getName());
            return;
        }
        filteredItems.forEach(updater);
    }
}
