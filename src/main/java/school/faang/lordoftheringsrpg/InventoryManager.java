package school.faang.lordoftheringsrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, BiConsumer<Character, Item> notice) {
        character.getInventory().add(item);
        notice.accept(character, item);
    }

    public void removeItemsIfSatisfyCondition(Character character, Predicate<Item> condition) {
        if (!character.getInventory().isEmpty()) {
            List<Item> itemsForRemoving = new ArrayList<>();
            character.getInventory().forEach(item -> {
                if (condition.test(item)) {
                    itemsForRemoving.add(item);
                }
            });
            if (!itemsForRemoving.isEmpty()) {
                itemsForRemoving.forEach(item -> character.getInventory().remove(item));
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> condition, Consumer<Item> itemChanger) {
        character.getInventory().forEach(item -> {
            if (condition.test(item)) {
                itemChanger.accept(item);
            }
        });
    }
}
