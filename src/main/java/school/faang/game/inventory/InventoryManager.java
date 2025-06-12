package school.faang.game.inventory;

import lombok.NonNull;
import school.faang.game.inventory.entity.Character;
import school.faang.game.inventory.entity.Item;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> handler) {
        character.getInventory().add(item);
        handler.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Predicate<Item> filter) {
        character.getInventory().removeIf(filter);
    }

    public void updateItem(@NonNull Character character, @NonNull Predicate<Item> filter,
                           @NonNull Function<Item, Item> processor) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (filter.test(item)) {
                inventory.set(i, processor.apply(item));
            }
        }
    }

    public boolean hasItem(@NonNull Character character, @NonNull Item item) {
        return character.getInventory().contains(item);
    }

    public void printAllItems(@NonNull Character character) {
        if (character.getInventory().isEmpty()) {
            System.out.printf("Character: \"%s\" has no any item in inventory\n", character.getName());
            return;
        }

        System.out.printf("Inventory of the character \"%s\":\n", character.getName());
        character.getInventory().forEach(item ->
                System.out.printf("Item name: \"%s\", cost: %d coins\n", item.getName(), item.getValue()));
    }
}
