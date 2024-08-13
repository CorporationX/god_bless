package lord_of_the_rings_rpg;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (!character.getInventory().removeIf(predicate)) {
            throw new NoSuchElementException("В инвентаре нет предмета, удовлетворяющего условию");
        };
    }

    public void updateItem(Character character,
                           Predicate<Item> predicate,
                           Function<Item, Item> updateFunction) {
        List<Item> inventory = character.getInventory();
        int index = IntStream.range(0, inventory.size())
                .filter(itemInd -> predicate.test(inventory.get(itemInd)))
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("В инвентаре нет предмета, удовлетворяющего условию")
                );
        inventory.set(index, updateFunction.apply(inventory.get(index)));
    }


}
