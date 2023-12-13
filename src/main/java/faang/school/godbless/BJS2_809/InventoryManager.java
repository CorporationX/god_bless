package faang.school.godbless.BJS2_809;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> check) {
        character.getInventory().removeIf(check);
    }

    public void updateItem(Character character, Predicate<Item> check, Function<Item, Item> action) {
        character.getInventory().replaceAll(item -> check.test(item) ? action.apply(item) : item);
    }
}