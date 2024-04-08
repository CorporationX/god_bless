package theLordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> conditionForRemoving) {
        int counter = 0;
        for (Item item : character.getInventory()) {
            if (conditionForRemoving.test(item)) {
                character.getInventory().remove(counter);
                break;
            }
            counter++;
        }
    }

    public void updateItem(Character character, Predicate<Item> conditionForUpdate, Function<Item, Item> functionForUpdate) {
        for (Item item : character.getInventory()) {
            if (conditionForUpdate.test(item)) {
                functionForUpdate.apply(item);
            }

        }
    }

    public void printInfoAboutCharacter(Character character) {
        Consumer<Character> consumer = character1 -> {
            System.out.println("Name: " + character1.getName() +
                    "\nInventory: " + character1.getInventory());
        };

        consumer.accept(character);
    }
}
