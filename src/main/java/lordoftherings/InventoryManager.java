package lordoftherings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        character.getInventory().add(item);
        onSuccess.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updater(Character character, Predicate<Item> condition, Function<Item, Item> function) {
        List<Item> inventoryOfCharacter = character.getInventory();
        for (int i = 0; i < inventoryOfCharacter.size(); i++) {
            if (condition.test(inventoryOfCharacter.get(i))) {
                inventoryOfCharacter.set(i, function.apply(inventoryOfCharacter.get(i)));
            }
        }
    }

}
