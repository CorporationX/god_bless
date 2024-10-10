package school.faang.lotrrpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        List<Item> inventory = character.getItems();

        if (inventory.size() < 5) {
            inventory.add(item);
            action.accept(item);
        } else {
            System.out.println("Инвентарь полон. Не удалось добавить " + item.getName());
        }
    }

    public void removeItem(Character character, Predicate<Item> condition, Consumer<Item> action) {
        List<Item> inventory = character.getItems();

        for (int i = 0; i < inventory.size(); i++) {
            if (condition.test(inventory.get(i))) {
                action.accept(inventory.get(i));
                inventory.remove(i);
                return;
            }
        }
        System.out.println("Предмет не найден в инвентаре.");
    }

    public void updateItem(Character character, Predicate<Item> condition, Consumer<Item> action) {
        List<Item> inventory = character.getItems();

        for (Item item : inventory) {
            if (condition.test(item)) {
                action.accept(item);
                return;
            }
        }
        System.out.println("Предмет не найден для обновления.");
    }
}