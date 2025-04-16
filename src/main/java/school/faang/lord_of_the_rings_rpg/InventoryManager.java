package school.faang.lord_of_the_rings_rpg;

import java.util.function.Consumer;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);  // Добавляем предмет в инвентарь
        consumer.accept(item);  // Выполняем действие над предметом
    }

    public void updateItem(Character frodo, Object theOneRing, Object o) {
    }
}
