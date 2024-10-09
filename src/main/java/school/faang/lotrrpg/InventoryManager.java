package school.faang.lotrrpg;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        Item[] inventory = character.getInventory();

        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = item;
                action.accept(item);
                return;
            }
        }
        System.out.println("Инвентарь полон. Не удалось добавить " + item.getName());
    }

    public void removeItem(Character character, Predicate<Item> condition, Consumer<Item> action) {
        Item[] inventory = character.getInventory();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && condition.test(inventory[i])) {
                action.accept(inventory[i]);
                inventory[i] = null;
                return;
            }
        }
        System.out.println("Предмет не найден в инвентаре.");
    }

    public void updateItem(Character character, Predicate<Item> condition, Consumer<Item> action) {
        Item[] inventory = character.getInventory();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && condition.test(inventory[i])) {
                action.accept(inventory[i]);
                return;
            }
        }
        System.out.println("Предмет не найден для обновления.");
    }
}
