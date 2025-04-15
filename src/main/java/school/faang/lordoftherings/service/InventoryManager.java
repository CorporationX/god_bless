package school.faang.lordoftherings.service;

import lombok.extern.slf4j.Slf4j;
import school.faang.lordoftherings.model.Character;
import school.faang.lordoftherings.model.Item;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> message) {
        if (!isValidCharacter(character) || item == null) {
            log.warn("Item is null or character is invalid");
            return;
        }
        character.getInventory().add(item);
        message.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> findItem) {
        if (!isValidCharacter(character)) {
            return;
        }
        if (character.getInventory().removeIf(findItem)) {
            log.info("Item removed from inventory");
            return;
        }
        log.warn("No matching item found to remove");
    }

    public void updateItem(Character character, Predicate<Item> findItem, Function<Item, Item> updated) {
        if (!isValidCharacter(character)) {
            return;
        }
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (findItem.test(item)) {
                Item updateItem = updated.apply(item);
                character.getInventory().set(i, updateItem);
                log.info("Item {} updated in inventory. New value: {}", item.getName(), updateItem.getValue());
                return;
            }
        }
        log.warn("No item found for update.");
    }

    private boolean isValidCharacter(Character character) {
        if (character == null) {
            log.warn("Character is null.");
            return false;
        }
        if (character.getInventory() == null) {
            log.warn("Character inventory is null.");
            return false;
        }
        return true;
    }
}