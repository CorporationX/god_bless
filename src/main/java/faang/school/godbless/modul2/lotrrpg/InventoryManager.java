package faang.school.godbless.modul2.lotrrpg;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemFilter) {
        emptyInventoryCheck(character);
        character.getInventory().removeIf(itemFilter);
    }

    public void updateItem(Character character, Predicate<Item> itemFilter, Function<Item, Item> updateFunction) {
        emptyInventoryCheck(character);
        character.getInventory().replaceAll(item -> itemFilter.test(item) ? updateFunction.apply(item) : item);
    }


    public void showInventory(Character character) {
        System.out.println(character.getName() + " inventory:");
        System.out.print("  ");
        character.getInventory().forEach(System.out::println);
    }

    private static void emptyInventoryCheck(Character character) {
        if (character.getInventory().size() == 0) {
            throw new NoSuchElementException("Inventory is empty");
        }
    }
}
