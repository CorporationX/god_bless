package Lord_of_the_Rings_RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item,
                        Consumer<Item> notificationOfAddition){
        character.setInventory(item);
        notificationOfAddition.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> conditionForRemoving){
        if (conditionForRemoving.test(character.getInventory())){
            character.setInventory(new Item());
        }
    }

    public void updateItem(Character character, Predicate<Item> conditionForUpdating,
                           Function<Item,Item> updatingItem){
        if (conditionForUpdating.test(character.getInventory())){
            updatingItem.apply(character.getInventory());
        }
    }
}
