package school.faang.lordOfTheRings80348;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        Iterator<Item> iterator = character.getInventory().iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (predicate.test(item)) {
                iterator.remove();
                System.out.printf("Предмет '%s' удален из инвентаря персонажа '%s' %n",
                        item.getName(), character.getName());
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                character.getInventory().set(character.getInventory().indexOf(item), function.apply(item));
            }
        }
    }
}


