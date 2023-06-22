package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer consumer) {
        character.addItemToInventory(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicateRemove) {
        character.getInventory().removeIf(predicateRemove);
    }

    public void updateItem(Character character, Predicate<Item> predicateUpdate, Function<Item, Item> itemFunction) {
        character.getInventory().stream()
                .filter(predicateUpdate)
                .findFirst()
                .ifPresent(f -> character.getInventory().set(character.getInventory().indexOf(f), itemFunction.apply(f)));
    }

}
