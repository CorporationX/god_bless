package school.faang.lambda.lotr_rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onAddMsg) {
        character.getInventory().add(item);
        onAddMsg.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        Stream<Item> trueCondition = character
                .getInventory()
                .stream()
                .filter(condition)
                .map(updater);

        Stream<Item> falseCondition = character
                .getInventory()
                .stream()
                .filter(condition.negate());

        List<Item> updatedList = Stream.concat(trueCondition, falseCondition).toList();
        character.getInventory().clear();
        character.getInventory().addAll(updatedList);
    }
}
