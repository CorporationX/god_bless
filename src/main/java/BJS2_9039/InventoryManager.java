package BJS2_9039;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> handler) {
        character.getItems().add(item);
        handler.accept(item);
    }
    public void removeItem(Character character, Predicate<Item> condition) {
        character.getItems().removeIf(condition);
    }
    public void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> upgrade) {
        character.getItems().replaceAll(item -> condition.test(item) ? upgrade.apply(item) : item);
    }
}