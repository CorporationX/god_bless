package lord.rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (!character.getInventory().contains(item)) {
            character.inventory.add(item);
            consumer.accept(item);
        } else {
            System.out.println("Нельзя добавить дубль предмета");
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {

        if (character.getInventory().removeIf(predicate)) {
            System.out.println("Удаляем");
        } else {
            throw new IllegalArgumentException("Не удаляем");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {

        var inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            if (predicate.test(inventory.get(i))) {
                inventory.set(i, function.apply((inventory.get(i))));
            }
        }
    }
}
