package faang.school.godbless.lordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
        // before shorten
//        character.getInventory().removeIf(item -> predicate.test(item));
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        character.getInventory().stream()
                .filter(predicate)
                .findFirst()
                .ifPresent(item -> character.getInventory()
                        .set(character.getInventory().indexOf(item),
                                function.apply(item)));
    }

}
