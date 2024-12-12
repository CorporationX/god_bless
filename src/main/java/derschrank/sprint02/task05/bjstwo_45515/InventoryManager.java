package derschrank.sprint02.task05.bjstwo_45515;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class InventoryManager implements InventoryManagerInterface {
    @Override
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character != null) {
            character.getInventory().add(item);
            consumer.accept(item);
        }
    }

    @Override
    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character != null) {
            Set<Item> inventory = character.getInventory();
            //Я знаю что можно заменить на одну строку, но хотел бы оставить так, чтоб смысл Предиката понимать
            // inventory.removeIf(predicate);
            for (Item item : character.getInventory()) {
                if (predicate.test(item)) {
                    inventory.remove(item);
                }
            }
        }
    }

    @Override
    public void updateItem(Character character, Predicate<Item> predicate, UnaryOperator<Item> function) {
        if (character != null) {
            Set<Item> inventory = character.getInventory();
            // А тут я не знаю, можно ли заменить на одну строку, ну кроме удаления?
            for (Item item : character.getInventory()) {
                if (predicate.test(item)) {
                    inventory.remove(item);
                    inventory.add(function.apply(item));
                }
            }
        }
    }
}
