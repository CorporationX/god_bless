package lord.rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (!character.getInventory().contains(item)) {
            character.getInventory().add(item);
            consumer.accept(item);
        } else {
            throw new IllegalArgumentException("Нельзя добавить дубль предмета");
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {

        if (!character.getInventory().removeIf(predicate)) {
            throw new IllegalArgumentException("Такого предмета нет в инвентаре.");
        } else {
            System.out.println("Предмет был удален");
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
