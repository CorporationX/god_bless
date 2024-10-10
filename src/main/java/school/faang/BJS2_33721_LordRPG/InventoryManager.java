package school.faang.BJS2_33721_LordRPG;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, int count, Consumer<Item> action) {
        ValidationUtils.validateCharacter(character);
        ValidationUtils.validateItem(item);
        ValidationUtils.validatePositiveInteger(count, "The number of added items cannot be less or equal to 0!");
        ValidationUtils.validateConsumer(action, "Action can't be null!");

        character.getInventory().merge(item, count, Integer::sum);
        action.accept(item);
    }

    public void removeItem(Character character, int count, Predicate<Item> condition) {
        ValidationUtils.validateCharacter(character);
        ValidationUtils.validatePositiveInteger(count, "The number of deleted items cannot be less or equal to 0!");
        ValidationUtils.validatePredicate(condition, "Condition can't be null!");

        character.getInventory().entrySet().removeIf(entry -> {
            if (condition.test(entry.getKey())) {
                int newCount = entry.getValue() - count;
                if (newCount <= 0) {
                    return true;
                }
                entry.setValue(newCount);
            }
            return false;
        });
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> itemMapper) {
        ValidationUtils.validateCharacter(character);
        ValidationUtils.validatePredicate(condition, "Condition can't be null!");
        ValidationUtils.validateFunction(itemMapper, "Item mapper can't be null!");

        Map<Item, Integer> inventory = character.getInventory();
        Iterator<Map.Entry<Item, Integer>> inventoryIterator = inventory.entrySet().iterator();

        while(inventoryIterator.hasNext()) {
            var entry = inventoryIterator.next();
            if (condition.test(entry.getKey())) {
                inventoryIterator.remove();
                Item newItem = itemMapper.apply(entry.getKey());
                inventory.put(newItem, entry.getValue());
            }
        }
    }
}
