package faang.school.godbless.lord_of_the_rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> describer) {
        character.getInventory().add(item);
        describer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isUseless) {
        character.getInventory().removeIf(isUseless);
    }

    public void updateItem(Character character, Predicate<Item> isUpdatable, Function<Item, Item> enhancer) {
        character.getInventory().replaceAll(item -> isUpdatable.test(item) ? enhancer.apply(item) : item);
    }
}
