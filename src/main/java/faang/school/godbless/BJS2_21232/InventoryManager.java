package faang.school.godbless.BJS2_21232;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> notificator) {
        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Inventory does not exist");
        }
        if (item == null) {
            throw new IllegalArgumentException("You must choose an item");
        }

        character.getInventory().add(item);
        notificator.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> control) {
        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Inventory does not exist");
        }

        character.getInventory().removeIf(control);
    }

    public void updateItem(Character character, Predicate<Item> control, Function<Item, Item> changeItem){
        if (character.getInventory() == null) {
            throw new IllegalArgumentException("Inventory does not exist");
        }

        character.getInventory().replaceAll(item -> control.test(item) ? changeItem.apply(item) : item);
    }
}
