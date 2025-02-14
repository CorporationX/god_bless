package school.faang.BJS2_57426;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class InventoryManager {

    public void addItem(Item item, Character character, Consumer<Item> handler) {
        Objects.requireNonNull(item);
        Objects.requireNonNull(character);
        Objects.requireNonNull(handler);
        character.getInventory().add(item);
        handler.accept(item);
    }

    public void removeItem(Item item, Character character, Predicate<Item> isInInventory) {
        Objects.requireNonNull(item);
        Objects.requireNonNull(character);
        Objects.requireNonNull(isInInventory);
        character.getInventory().removeIf(isInInventory);
    }

    public void updateItem(Item item, Character character, UnaryOperator<Item> update) {
        Objects.requireNonNull(item);
        Objects.requireNonNull(character);
        Objects.requireNonNull(update);
        if (!character.getInventory().contains(item)) {
            throw new NoSuchElementException("Предмета %s нет в инвентаре %s".formatted(item, character));
        }
        update.apply(item);
    }
}
