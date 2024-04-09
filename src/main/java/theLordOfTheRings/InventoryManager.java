package theLordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        character.getInventory().add(item);
        onSuccess.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> conditionForRemoving) {
        character.getInventory().removeIf(conditionForRemoving);
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
