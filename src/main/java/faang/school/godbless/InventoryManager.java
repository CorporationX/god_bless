package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> callback){
        character.getInventory().add(item);
        callback.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate){
        List<Item> inventory =  character.getInventory();
        inventory.removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updateFunction) {
        List<Item> inventory = character.getInventory();
        for(Item item : inventory){
            if(predicate.test(item)){
                Item updatedItem = updateFunction.apply(item);
                int index = inventory.indexOf(item);
                inventory.set(index, updatedItem);
                break;
            }
        }

    }

}
