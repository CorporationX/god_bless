package school.faang.lord_of_the_tings;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    private Character character;

    public InventoryManager(Character character) {
        this.character = character;
    }

    public void updateItem(Predicate<Item> predicate, int newValue) {
        for (Item verifiable : character.getInventory()) {
            if (predicate.test(verifiable)) {
                if (itemUpdate.apply(verifiable, newValue)) {
                    System.out.println("Стоимость: " + verifiable.getName() + " обновлена! Поздравляем! Теперь ценаЖ "
                            + verifiable.getValue());
                }
            }
        }
    }

    public void addItem(Item item) {
        itemAdder.accept(item);
        System.out.println("Добавлен предмет: " + item.getName() + " стоимостью: " + item.getValue());
    }

    public void removeItem(Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    private final Consumer<Item> itemAdder = item -> character.getInventory().add(item);
    private final BiFunction<Item, Integer, Boolean> itemUpdate = (item, newValue) -> {
        item.setValue(newValue);
        return true;
    };
}
