package LordOfRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Item item, Character character, Predicate<Item> filter) {
        if (filter.test(item)) {
            character.getInventory().remove(item);
            System.out.println(item.getName() + " remove from inventory");
        }
    }

    public static void updateItem(Character character, Predicate<Item> filter, Function<Integer, Integer> update) {
        List<Item> itemList = character.getInventory();
        for (Item unit : itemList) {
            if (filter.test(unit)) {
                unit.setValue(update.apply(unit.getValue()));
                System.out.println("The cost of the " + unit.getName() + "  has doubled");
            }
        }

    }
}
