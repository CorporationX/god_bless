package faang.school.godbless.Lord.of.the.Rings.RPG;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character.getInventory() == null){
            character.setInventory(new ArrayList<Item>());
        }

        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> inventory = character.getInventory();

        for (Item item : inventory) {
            if (predicate.test(item)) {
                inventory.remove(item);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = character.getInventory();

        for (Item item : inventory) {
            if (predicate.test(item)) {
                inventory.set(inventory.indexOf(item), function.apply(item));
            }
        }
    }
}
