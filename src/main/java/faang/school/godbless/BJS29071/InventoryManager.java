package faang.school.godbless.BJS29071;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> predicate) {
        if (item == null) {
            throw new NullPointerException("Item is null");
        }
        if (character == null) {
            throw new NullPointerException("Character is null");
        }

        character.getInventory().add(item);
        predicate.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().isEmpty()) {
            System.out.println(character.getName() + "'s inventory is empty");
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> func) {
        if (character.getInventory().isEmpty()) {
            System.out.println(character.getName() + "'s inventory is empty");
        }
        List<Item> updatedItems = character.getInventory().stream().filter(predicate)
                .map(item -> func.apply(item)).toList();
        character.setInventory(updatedItems);
    }
}
