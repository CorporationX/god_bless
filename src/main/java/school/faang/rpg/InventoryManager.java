package school.faang.rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> addFunc) {
        character.getInventory().add(item);
        addFunc.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> updateFunction) {
        // без стримов додумался до такой реализации
        for(Item item: character.getInventory()) {
            if(filter.test(item)) {
                int index = character.getInventory().indexOf(item);
                character.getInventory().set(index, updateFunction.apply(item));
            }
        }
    }
}
