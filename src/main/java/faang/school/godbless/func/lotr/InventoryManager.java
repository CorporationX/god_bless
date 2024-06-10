package faang.school.godbless.func.lotr;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public record InventoryManager() {

    public void addItem(Character character, Item item, Consumer<Item> reportSuccess) {
        if (character == null || item == null || reportSuccess == null) {
            throw new IllegalArgumentException("Action items and function cannot be null");
        }
        if (character.getInventory().add(item)) {
            reportSuccess.accept(item);
        }
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        if (character == null || condition == null) {
            throw new IllegalArgumentException("Action items and function cannot be null");
        }
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        if (character == null || condition == null || updater == null) {
            throw new IllegalArgumentException("Action items and function cannot be null");
        }
        character.getInventory().replaceAll(item -> condition.test(item) ? updater.apply(item) : item);
    }
}
