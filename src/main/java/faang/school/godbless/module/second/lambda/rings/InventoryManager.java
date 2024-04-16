package faang.school.godbless.module.second.lambda.rings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> positiveAction) {
        character.getInventory().add(item);
        positiveAction.accept(item);
    }
    
    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }
    
    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> convertAction) {
        List<Item> inventory = character.getInventory();
        //Пришлось использовать итерирование через for, т.к через foreach нельзя заменить элемент
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, convertAction.apply(item));
            }
        }
    }
}
