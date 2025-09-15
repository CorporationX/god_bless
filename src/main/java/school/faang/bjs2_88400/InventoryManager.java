package school.faang.bjs2_88400;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Consumer<Character> handler) {
        handler.accept(character);
    }

    public void removeItem(Character character, Predicate<Item> checker) {
        if (character.getInventory().removeIf(checker)) {
            System.out.println("Предметы удалены из инвентаря");
        } else {
            System.out.println("Нет предметов для удаления");
        }
    }

    public void updateItem(Character character, Predicate<Item> checker, Function<Item, Item> converter) {
        boolean isUpdated = false;
        for (Item item : character.getInventory()) {
            if (checker.test(item)) {
                converter.apply(item);
                isUpdated = true;
            }
        }
        if (isUpdated) {
            System.out.println("Предметы обновлены в инвентаре");
        } else {
            System.out.println("Нет предметов для обновления");
        }
    }
}
