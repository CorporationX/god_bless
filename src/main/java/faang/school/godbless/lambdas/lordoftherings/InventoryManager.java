package faang.school.godbless.lambdas.lordoftherings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> onItemAdded) {
        character.getInventory().add(item);
        onItemAdded.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> removalCondition) {
        character.getInventory().removeIf(removalCondition);
    }

    public void updateItem(Character character, Predicate<Item> updatingCondition, Function<Item, Item> updatingFunction) {
        UnaryOperator<Item> replacingOperator = item -> updatingCondition.test(item) ? updatingFunction.apply(item) : item;
        character.getInventory().replaceAll(replacingOperator);
    }

}
