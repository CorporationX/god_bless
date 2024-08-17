package faang.school.godbless.modul2.lotrrpg;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

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

        List<Item> inventory = character.getInventory();
        IntStream.range(0, inventory.size())
                .filter(i -> itemFilter.test(inventory.get(i)))
                .forEach(i -> inventory.set(i, updateFunction.apply(inventory.get(i))));
    }


    public void showInventory(Character character) {
        System.out.println("\n" + character.getName() + " inventory:");
        System.out.print("  ");
        character.getInventory().forEach(System.out::println);
    }

    private static void emptyInventoryCheck(Character character) {
        if (character.getInventory().size() == 0) {
            throw new NoSuchElementException("Inventory is empty");
        }
    }
}
