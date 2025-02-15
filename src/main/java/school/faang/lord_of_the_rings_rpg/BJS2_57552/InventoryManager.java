package school.faang.lord_of_the_rings_rpg.BJS2_57552;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryManager.class);

    public void addItem(Character character, Item itemName, Consumer<Item> action) {
        validateObjectNull(character == null, "character is null");
        validateObjectNull(itemName == null, "itemName is null");
        validateObjectNull(action == null, "action is null");

        character.getInventory().add(itemName);
        action.accept(itemName);

        LOGGER.info("Added item {} to character {}", itemName, character);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        validateObjectNull(predicate == null, "predicate is null");
        validateObjectNull(character == null, "character is null");

        character.getInventory().removeIf(predicate);

        LOGGER.info("Removed character {} from inventory", character);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> action) {
        validateObjectNull(predicate == null, "predicate is null");
        validateObjectNull(character == null, "character is null");
        validateObjectNull(action == null, "action is null");

        character.getInventory().replaceAll(item -> {
            if (predicate.test(item)) {
                return action.apply(item);
            }
            return item;
        });
        LOGGER.info("Updated character {} from inventory", character);
    }

    private static void validateObjectNull(Object object, String errorMessage) {
        if (object == null) {
            LOGGER.error(errorMessage, (Object) null);
            throw new IllegalArgumentException(String.format(errorMessage, (Object) null));
        }
    }

}
