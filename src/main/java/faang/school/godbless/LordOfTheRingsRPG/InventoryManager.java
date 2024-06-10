package faang.school.godbless.LordOfTheRingsRPG;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    void addItem(Character character, Item item, Consumer<String> consumer){
        character.getInventory().add(item);
        consumer.accept(item.getName());
    }
    void removeItem(Character character, Predicate<Item> predicate){
        for (Item item: character.getInventory()) {
            if(predicate.test(item)){
                character.
            }
            
        }
    }
}
