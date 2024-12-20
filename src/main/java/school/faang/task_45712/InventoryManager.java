package school.faang.task_45712;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item itemToAdd, Consumer<Item> addFunc) {
        addFunc.accept(itemToAdd);
        character.getInventory().add(itemToAdd);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        Iterator<Item> iterator = character.getInventory().iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (predicate.test(item)) {
                iterator.remove();
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> func) {
        for(int i = 0; i < character.getInventory().size(); i++) {
            Item currentItem = character.getInventory().get(i);
            if (predicate.test(currentItem)) {
                character.getInventory().set(i, func.apply(character.getInventory().get(i)));
            }
        }
    }
}
