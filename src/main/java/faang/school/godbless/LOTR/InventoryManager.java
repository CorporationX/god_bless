package faang.school.godbless.LOTR;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer){
        character.addItem(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate){
        character.getInventory().forEach(item -> {
            if (itemPredicate.test(item)){
                character.removeItem(item);
            }
        });
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction){

    }
}
