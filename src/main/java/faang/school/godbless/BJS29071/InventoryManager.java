package faang.school.godbless.BJS29071;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> predicate) {
        if (item == null) {
            System.out.println("Item is null");
            return;
        }
        if (character == null) {
            System.out.println("Character is null");
            return;
        }

        character.getInventory().add(item);
        predicate.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character.getInventory().isEmpty()) {
            System.out.println(character.getName() + "'s inventory is empty");
            return;
        }
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> func) {
        if (character.getInventory().isEmpty()) {
            System.out.println(character.getName() + "'s inventory is empty");
            return;
        }
        List<Item> updatedItems = character.getInventory().stream().filter(predicate)
                .map(item -> func.apply(item)).toList();
        character.setInventory(updatedItems);
    }
}
