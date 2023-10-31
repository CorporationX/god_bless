package faang.school.godbless;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer){
        character.inventory.add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition){
        if (character.inventory.size()<1){
            throw new IllegalArgumentException("Inventory is empty");
        }
        character.inventory.removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update){
        if (character.inventory.size()<1){
            throw new IllegalArgumentException("Inventory is empty");
        }
        character.updateItemIf(condition, update);
    }
}
