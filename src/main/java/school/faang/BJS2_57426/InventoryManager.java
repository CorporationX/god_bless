package school.faang.BJS2_57426;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Item item, Character character, Consumer<Item> handler) {
        character.getInventory().add(item);
        handler.accept(item);
    }

    public void removeItem(Item item, Character character, Predicate<Item> isInInventory) {
        if (isInInventory.test(item)) {
            character.getInventory().remove(item);
        }
    }

    public void updateItem(Item item, Character character, Function<Item, Integer> changePrice) {
        if (!character.getInventory().contains(item)) {
            throw new NoSuchElementException("Предмета %s нет в инвентаре %s".formatted(item, character));
        }
        int newPrice = changePrice.apply(item);
        item.setValue(newPrice);
    }
}
