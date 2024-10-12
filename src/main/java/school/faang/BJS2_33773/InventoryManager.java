package school.faang.BJS2_33773;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action){
        character.addItem(item);
        action.accept(item);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> action){
        for(Item item : character.getItems()){
            if(predicate.test(item)){
                item.setValue(action.apply(item).getValue());
            }
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate){
        character.getItems().removeIf(predicate);
    }
}
