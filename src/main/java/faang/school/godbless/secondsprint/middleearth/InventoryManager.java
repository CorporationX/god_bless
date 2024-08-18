package faang.school.godbless.secondsprint.middleearth;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> onSuccess) {
        character.getInventory().add(item);
        onSuccess.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        character.setInventory(
                character.getInventory().stream()
                        .map(item -> condition.test(item) ? updater.apply(item) : item)
                        .collect(Collectors.toList())
        );
    }
}
