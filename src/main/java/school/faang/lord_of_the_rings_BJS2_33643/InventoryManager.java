package school.faang.lord_of_the_rings_BJS2_33643;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        consumer.accept(item);
            character.getInventory().add(item);
    }

    public void removeItem(Character character,  Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item,Item> function){
        for (Item item : character.getInventory()) {
            if(predicate.test(item)){
                character.getInventory().remove(item);
                character.getInventory().add(function.apply(item));
            }
        }
    }

}
