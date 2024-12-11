package school.faang.bjs245552;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class InventoryManager {
    private final Map<String, Character> characterMap;

    public InventoryManager() {
        characterMap = new HashMap<>();
    }

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        if (character == null) {
            throw new IllegalArgumentException("Character was not specified in request");
        }
        if (item == null) {
            throw new IllegalArgumentException("Invalid item operation specified for character inventory");
        }
        if (consumer == null) {
            throw new IllegalArgumentException("Invalid item operation specified for character inventory");
        }

        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        if (character == null) {
            throw new IllegalArgumentException("Character was not specified in request");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("Invalid item check operation specified for character inventory");
        }

        boolean removed = character.getInventory().removeIf(predicate);
        if (!removed) {
            throw new IllegalArgumentException("Item was not found in character's inventory");
        } else {
            System.out.println("Item was removed from character's inventory");
        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        if (character == null) {
            throw new IllegalArgumentException("Character was not specified in request");
        }
        if (predicate == null) {
            throw new IllegalArgumentException("Invalid item check operation specified for character inventory");
        }
        if (function == null) {
            throw new IllegalArgumentException("Invalid item update operation specified for character inventory");
        }

        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (predicate.test(item)) {
                character.getInventory().set(i, function.apply(item));
            }
        }

        //not as effective as updates whole the list
        //character.getInventory().replaceAll(item -> predicate.test(item) ? function.apply(item) : item);
    }
}
