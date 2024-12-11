package school.faang.bjs245552;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class InventoryManager {
    private final Map<String, Character> characterMap = new HashMap<>();

    private void validate(Object... params) {
        for (int i = 0; i < params.length; i += 2) {
            if (params[i] == null) {
                throw new IllegalArgumentException(String.format("%s was not specified in request", params[i + 1]));
            }
        }
    }

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        validate(character, "character", item, "item", consumer, "consumer");

        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        validate(character, "character", predicate, "predicate");

        List<String> charactersToRemove = character.getInventory().stream().filter(predicate).map(Item::getName).toList();
        if (charactersToRemove.isEmpty()) {
            throw new IllegalArgumentException("Item was not found in character's inventory");
        } else {
            character.getInventory().removeIf(predicate);
            System.out.printf("Item(s): %s was/were removed from character's inventory", String.join( ", ", charactersToRemove));
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        validate(character, "character", predicate, "predicate", function, "function");

        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (predicate.test(item)) {
                character.getInventory().set(i, function.apply(item));
            }
        }
    }
}
