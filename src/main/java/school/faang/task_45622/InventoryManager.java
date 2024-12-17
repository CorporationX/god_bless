package school.faang.task_45622;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if ((character != null) && (item != null) && (consumer != null)) {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) throws IllegalArgumentException {
        if ((character == null) || (predicate == null)) {
            throw new IllegalArgumentException("Remove item error: Functional or character is null!!!");
        }
        character.getInventory().removeIf(predicate);
        System.out.println("Предмет удален!!!");

    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updateItem) {
        if ((character == null) || (predicate == null)) {
            throw new IllegalArgumentException("Update item error: Functional or character is null!!!");
        }
        boolean availableItem = false;
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                availableItem = true;
                character.getInventory().set(i, updateItem.apply(character.getInventory().get(i)));
            }
        }
        if (!availableItem) {
            System.out.println("Данного предмета нет в инвентаре!!!");
        }

    }
}
