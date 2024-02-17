package faang.school.godbless.rpg;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        character.getInventory().add(item);
        onSuccess.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> update) {
        Iterator<Item> iterator = character.getInventory().iterator();
        int index = -1;
        boolean exist = false;
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (condition.test(item)) {
                index = character.getInventory().indexOf(item);
                exist = true;
            }
        }
        if (exist) {
            character.getInventory().set(index, update.apply(character.getInventory().get(index)));
            System.out.println("Item is updated");
        }
    }
}
