package lordrpg;

import java.util.function.Predicate;
import java.util.function.Function;

public class InventoryManager {

    // Метод для добавления предмета в инвентарь
    public void addItem(Character character, Item item, java.util.function.Consumer<Item> action) {
        character.addItem(item);
        action.accept(item);  // выполняем дополнительное действие
    }

    // Метод для удаления предмета, если он удовлетворяет предикату
    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    // Метод для обновления предмета в инвентаре с использованием функции
    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        for (Item item : character.getInventory()) {
            if (condition.test(item)) {
                Item updatedItem = updateFunction.apply(item);
                character.removeItem(item);
                character.addItem(updatedItem);
            }
        }
    }
}
