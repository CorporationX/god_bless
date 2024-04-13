package faang.school.godbless.lordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> addItem) {
        character.getInventory().add(item);
        addItem.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isSatisfied) {
        for(Item item : character.getInventory()) {
            if (isSatisfied.test(item)) {
                character.getInventory().remove(item);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> isSatisfied, Function<Item, Item> needAction) {
        for(Item item : character.getInventory()) {
            if (isSatisfied.test(item)) {
                needAction.apply(item);
            }
        }
    }
}