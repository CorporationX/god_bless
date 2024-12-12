package derschrank.sprint02.task05.bjstwo_45515;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface InventoryManagerInterface {
    void addItem(Character character, Item item, Consumer<Item> consumer);

    void removeItem(Character character, Predicate<Item> predicate);

    void updateItem(Character character, Predicate<Item> predicate, UnaryOperator<Item> function);
}
