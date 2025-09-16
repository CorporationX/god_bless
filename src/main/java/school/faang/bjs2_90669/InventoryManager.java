package school.faang.bjs2_90669;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, UnaryOperator<Item> updater) {
        List<Item> inventory = character.getInventory();

        List<Item> updatedItems = inventory.stream()
                .filter(predicate)
                .map(updater)
                .toList();

        inventory.removeIf(predicate);
        inventory.addAll(updatedItems);
    }
}



