package faang.school.godbless.BJS2_9106;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> printStatus) {
        if (character == null || item == null || printStatus == null) {
            throw new IllegalArgumentException("Some arguments was illegal");
        }

        character.getInventory().add(item);
        printStatus.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null || condition == null) {
            throw new IllegalArgumentException("Some arguments was illegal");
        }

        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updateFunction) {
        if (character == null || condition == null || updateFunction == null) {
            throw new IllegalArgumentException("Some arguments was illegal");
        }

        //  применяет функцию под все подходящие условия и заменяет эти объекты в inventory
        character.getInventory().replaceAll(item -> condition.test(item) ? updateFunction.apply(item): item);
    }
}
