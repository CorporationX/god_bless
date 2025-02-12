package school.faang.rpg.lord_of_the_rings;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private static Logger logger = LoggerFactory.getLogger(InventoryManager.class);

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        checkValidArgument(character, "Character");
        checkValidArgument(item, "Item");
        checkValidArgument(consumer, "Consumer");
        character.getInventory().add(item);
        consumer.accept(item);
        logger.info("{} was added.", item.getName());
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        checkValidArgument(character, "Character");
        checkValidArgument(predicate, "Predicate");
        List<Item> inventory = character.getInventory();
        List<Item> selectedItem = inventory.stream().filter(predicate).toList();
        inventory.removeIf(predicate);
        logger.info("Was removed:\n{}", selectedItem.toString());
    }


    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        checkValidArgument(character, "Character");
        checkValidArgument(predicate, "Predicate");
        checkValidArgument(updater, "Consumer");
        List<Item> inventory = character.getInventory();
        List<Item> selectedItem = inventory.stream().filter(predicate).toList();
        character.getInventory().replaceAll(item -> predicate.test(item) ? updater.apply(item) : item);
        logger.info("Was updated:\n{}", selectedItem.toString());
    }

    private <T> void checkValidArgument(T argument, String argumentName) {
        if (argument == null) {
            logger.error("The argument {} cannot be null! Location {} : {}", argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            throw new IllegalArgumentException("The argument " + argumentName + " cannot be null!");
        }
        if (argument.getClass() == String.class) {
            logger.error("The argument {} cannot be bkank! Location {} : {}", argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            throw new IllegalArgumentException("The argument " + argumentName + " cannot be blank!");
        }
    }
}
