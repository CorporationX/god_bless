package faang.school.godbless.lord_of_rings;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> addingDetails){
        if(character == null || item == null || addingDetails == null){
            throw new IllegalArgumentException("Character, item and adding details cannot be null");
        }
        character.getInventory().add(item);
        addingDetails.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> remotingDetails){
        if(character == null || remotingDetails == null){
            throw new IllegalArgumentException("Character and removingDetails cannot be null");
        }
        boolean result = character.getInventory().removeIf(remotingDetails);
        if(!result){
            log.warn("Could not find and remove needed item");
        }
    }

    public void updateItem(Character character, Predicate<Item> itemDetails, Function<Item, Item> modifier){
        if(character == null || itemDetails == null || modifier == null){
            throw new IllegalArgumentException("Character, item details and modifier cannot be null");
        }
        boolean isUpdated = false;
        List<Item> items = character.getInventory();
        for(int pos = 0; pos < character.getInventory().size(); pos++){
            Item itemIteration = items.get(pos);
            if(itemDetails.test(itemIteration)){
                items.set(pos, modifier.apply(itemIteration));
                isUpdated = true;
            }
        }
        if(!isUpdated){
            log.warn("Could not find and update any matching item");
        }
    }
}
