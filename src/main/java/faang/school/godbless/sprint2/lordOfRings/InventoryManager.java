package faang.school.godbless.sprint2.lordOfRings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> successConsumer) {
        if (Character.isValidCharacter(character) && Item.isValidItem(item) && successConsumer != null) {
            character.getInventory().add(item);

            successConsumer.accept(item);
        } else {
            throw new IllegalArgumentException("Incorrect arguments");
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (Character.isValidCharacter(character) && isValidPredicate(predicate)) {
            character.getInventory().removeIf(predicate);
        } else {
            throw new IllegalArgumentException("Incorrect arguments");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (Character.isValidCharacter(character) && isValidPredicate(predicate) && function != null) {
            character.setInventory(character.getInventory().stream()
                    .filter(predicate)
                    .map(function)
                    .collect(Collectors.toList()));
        } else {
            throw new IllegalArgumentException("Incorrect arguments");
        }
    }

    private boolean isValidPredicate(Predicate predicate) {
        return predicate != null;
    }
}
