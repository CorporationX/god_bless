package faang.school.godbless.sprint3.LordOfTheRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        List<Item> inventory = character.getInventory();
        inventory.add(item);
        character.setInventory(inventory);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> check) {
        List<Item> inventory = character.getInventory();
        inventory.removeIf(check);
        character.setInventory(inventory);
    }

    public void updateItem(Character character, Predicate<Item> check, Function<Item, Item> update) {
        List<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (check.test(item)) {
                inventory.add(update.apply(item));
                inventory.remove(item);
            }

        }
    }

    public void printInventory(Character character) {
        for (Item item : character.getInventory()) {
            System.out.println(item.getName() + " " + item.getValue());
        }
    }
}
