package school.faang.bjs245635;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private static final Logger logger = LoggerFactory.getLogger(InventoryManager.class);

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null || item == null || consumer == null) {
            logger.error("Invalid arguments: character={}, item={}, consumer={}", character, item, consumer);
            throw new IllegalArgumentException("Character, item, and consumer must not be null");
        }
        character.getInventory().add(item);
        consumer.accept(item);
        logger.info("Item {} added to character {}'s inventory", item.getName(), character.getName());
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        if (character == null || itemPredicate == null) {
            logger.error("Invalid arguments: character={}, itemPredicate={}", character, itemPredicate);
            throw new IllegalArgumentException("Character and itemPredicate must not be null");
        }
        boolean removed = character.getInventory().removeIf(itemPredicate);
        if (removed) {
            logger.info("predicate elements have been removed");
        } else {
            logger.info("No items matching given conditions ");
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> updater) {
        if (character == null || itemPredicate == null || updater == null) {
            logger.error("Invalid arguments: character={}, itemPredicate={}, updater={}",
                    character, itemPredicate, updater);
            throw new IllegalArgumentException("Character, itemPredicate, and updater must not be null");
        }
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (itemPredicate.test(item)) {
                inventory.set(i, updater.apply(item));
                logger.info("Items in character {}'s inventory have been updated", character.getName());
            } else {
                logger.info("Item did not match the predicate and was not updated");
            }
        }
    }
}


