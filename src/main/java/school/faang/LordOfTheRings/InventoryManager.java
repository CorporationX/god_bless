package school.faang.LordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer){
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isItem){
            character.getInventory().removeIf(isItem);
    }

    public void updateItem(Character character, Predicate<Item> isItem, Consumer<Item> newItem){
        for (Item item : character.getInventory()){
            if (isItem.test(item)){
                newItem.accept(item);
            }
        }
    }
}
