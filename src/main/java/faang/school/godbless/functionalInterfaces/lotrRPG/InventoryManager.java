package faang.school.godbless.functionalInterfaces.lotrRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        if (character == null || item == null || action == null) {
            throw new IllegalArgumentException("All args must be non-valued!");
        }

        character.getInventory().add(item);
        action.accept(item);
    }

    public boolean removeItem(Character character, Predicate<Item> deleteCondition) {
        if (character == null || deleteCondition == null) {
            throw new IllegalArgumentException("All args must be non-valued!");
        }

        return character.getInventory().removeIf(deleteCondition);
    }

    public void updateItem(Character character, Predicate<Item> updateCondition, Function<Item, Item> updateFunction) {
        if (character == null || updateCondition == null || updateFunction == null) {
            throw new IllegalArgumentException("All args must be non-valued!");
        }

        var characterInventory = character.getInventory();
        var itemsToBeUpdated = characterInventory.stream()
                .filter(updateCondition)
                .toList();

        characterInventory.removeAll(itemsToBeUpdated);
        characterInventory.addAll(itemsToBeUpdated.stream().map(updateFunction).toList());
    }

    public void printInventory(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("All args must be non-valued!");
        }

        System.out.println("I have in my inventory:");

        if (character.getInventory().size() == 0) {
            System.out.println("Nothing!\n");
            return;
        }

        character.getInventory().forEach(System.out::println);
        System.out.println();
    }
}
