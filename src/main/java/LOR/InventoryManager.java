package LOR;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem (Character character, Item item, Consumer<Character> add){
        character.getInventory().add(item);
        add.accept(character);
    }
    void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }
    void updateItem(Character character, Predicate<Item> predicate, Function<Item,Item> update){
        for (Item item : character.getInventory()){
            if (predicate.test(item)){
                update.apply(item);
                break;
            }
        }
    }
}
