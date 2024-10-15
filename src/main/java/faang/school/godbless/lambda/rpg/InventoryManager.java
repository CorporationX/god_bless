package faang.school.godbless.lambda.rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> additionalAction) {
        character.getInventory().add(item);
        additionalAction.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> removingCondition) {
        character.getInventory().removeIf(removingCondition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> action) {
        var needItems = character.getInventory().stream().filter(condition).toList();
        character.getInventory().removeAll(needItems);
        character.getInventory().addAll(needItems.stream().map(action).toList());
    }

}
