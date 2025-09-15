package school.faang.bjs2_90669;

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
        character.getInventory().stream()
                .filter(predicate)
                .findFirst()
                .ifPresent(item -> {
                    Item updatedItem = updater.apply(item);
                    item.setName(updatedItem.getName());
                    item.setValue(updatedItem.getValue());
                });
    }
}



