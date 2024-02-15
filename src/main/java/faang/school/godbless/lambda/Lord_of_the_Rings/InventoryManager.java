package faang.school.godbless.lambda.Lord_of_the_Rings;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action){
        character.getInventory().add(item);
        action.accept(item);
    }
    public void removeItem(Character character, Predicate<Item> filter){
        Iterator<Item> iterator = character.getInventory().iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            boolean isRemove = filter.test(item);
            if(isRemove){
                iterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function){
        for(Item item: character.getInventory()){
            if(predicate.test(item)){
                function.apply(item);
            }
        }
    }
}
