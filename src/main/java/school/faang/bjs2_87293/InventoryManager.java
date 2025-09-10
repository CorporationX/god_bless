package school.faang.bjs2_87293;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private InventoryManager() {

    }

    public static void addItem(Item item, Character character, Consumer<Item> itemAdder) {
        character.getInventory().add(item);
        itemAdder.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> isInInventory) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (isInInventory.test(item)) {
                character.getInventory().remove(item);
                System.out.printf("Удалён предмет %s", item.getName());
                System.out.println();
            }
        }
    }

    public static void updateItem(Character character, Predicate<Item> comparator, Function<Item, Item> updater) {
        for (Item item : character.getInventory()) {
            if (comparator.test(item)) {
                updater.apply(item);
                System.out.printf("Обновлён предмет %s", item.getName());
                System.out.println();
            }
        }
    }
}