package school.faang.bjs2_88400;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, BiConsumer<Character, Item> handler) {
        handler.accept(character, item);
    }

    public void removeItem(Character character, Predicate<Item> checker) {
        int size = character.getInventory().size();
        character.setInventory(
                character.getInventory().stream()
                        .filter(checker)
                        .collect(Collectors.toCollection(ArrayList::new))
        );
        if (character.getInventory().size() == size)
            System.out.println("Нет предметов для удаления");
        else {
            System.out.println("Предметы удалены из инвентаря");
        }
    }

    public void updateItem(Character character, Predicate<Item> checker, Function<Item, Integer> converter) {
        boolean isUpdated = false;
        for (Item item : character.getInventory()) {
            if (checker.test(item)) {
                item.setAmount(converter.apply(item));
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
