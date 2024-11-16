package faang.school.godbless.lambda.lord;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Character> afterAdd) {
        character.addItem(item);
        afterAdd.accept(character);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.removeItem(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        character.updateItem(predicate, updater);
    }

    public void printInventory(Character character) {
        character.printInventory();
    }
}
