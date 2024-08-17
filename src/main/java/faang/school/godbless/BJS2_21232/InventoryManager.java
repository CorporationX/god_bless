package faang.school.godbless.BJS2_21232;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        validateInventory(character.getInventory());

        if (item == null) {
            throw new IllegalArgumentException("You must choose an item");
        }

        character.getInventory().add(item);
        onSuccess.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> control) {
        validateInventory(character.getInventory());

        character.getInventory().removeIf(control);
    }

    public void updateItem(Character character, Predicate<Item> control, Function<Item, Item> changeItem){
        validateInventory(character.getInventory());

        character.getInventory().replaceAll(item -> control.test(item) ? changeItem.apply(item) : item);
    }

    private void validateInventory(List<Item> inventory){
        if(inventory == null)
            throw new IllegalArgumentException("Inventory does not exist");
    }
}
