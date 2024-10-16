package school.faang.bjs2_33879.service;

import lombok.NonNull;
import school.faang.bjs2_33879.model.Character;
import school.faang.bjs2_33879.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    private final ValidatorInventoryManager validator = new ValidatorInventoryManager();

    public void addItem(@NonNull Character character, @NonNull Item item, @NonNull Consumer<Item> additionalAction) {

        List<Item> inventory = character.getInventory();
        if (inventory == null) {
            inventory = new ArrayList<>();
            character.setInventory(inventory);
        }
        inventory.add(item);

        additionalAction.accept(item);
    }

    public void removeItem(@NonNull Character character, @NonNull Item item, @NonNull Predicate<Item> deletionCondition) {
        validator.validateInventoryNotNull(character);

        if (deletionCondition.test(item)) {
            List<Item> inventory = character.getInventory();
            inventory.remove(item);
            if (inventory.isEmpty()) {
                character.setInventory(null);
            }
        }
    }

    public void updateItem(@NonNull Character character, @NonNull Predicate<Item> updCondition, @NonNull Function<Item, Item> updateAction) {
        validator.validateInventoryNotNull(character);

        List<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (updCondition.test(item)) {
                int indexItem = inventory.indexOf(item);
                item = updateAction.apply(item);
                inventory.set(indexItem, item);
            }
        }
    }
}
