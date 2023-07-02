package faang.school.godbless.Lord_of_the_Rings_RPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer){
        character.setInventory(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate){
        if (predicate.test(character.getInventory())){
            character.setInventory(new Item("Empty", 0));
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function){
        if (predicate.test(character.getInventory())){
            character.setInventory(function.apply(character.getInventory()));
        }
    }
}
