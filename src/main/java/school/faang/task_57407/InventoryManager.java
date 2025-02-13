package school.faang.task_57407;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class InventoryManager {
    public void addItem(Character character, Item item,
                        Consumer<Item> consumer) {
        checkCharacter(character);
        checkItem(item);
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        checkCharacter(character);
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        checkCharacter(character);
        character.getInventory().replaceAll(item ->
                predicate.test(item) ? function.apply(item) : item);
    }

    private void checkCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException("character не можент быть null");
        }
    }

    private void checkItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item не можент быть null");
        }
    }


}
