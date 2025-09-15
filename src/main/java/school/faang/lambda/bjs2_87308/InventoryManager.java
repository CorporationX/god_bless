package school.faang.lambda.bjs2_87308;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(@NonNull Character character, @NonNull Item item, Consumer<Item> consumer) {
        if (!character.getItems().contains(item)) {
            character.getItems().add(item);
            consumer.accept(item);
        } else {
            System.out.printf("Character %s already has item %s\n", character.getName(), item.getName());
        }
    }

    public void removeItem(@NonNull Character character, Predicate<Item> predicate) {
        character.getItems().removeIf(predicate);
    }

    public void updateItem(@NonNull Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        final List<Item> characterItems = character.getItems();
        boolean isUpdated = false;
        for (int i = 0; i < characterItems.size(); i++) {
            final Item item = characterItems.get(i);
            if (predicate.test(item)) {
                isUpdated = true;
                final String itemNameBefore = item.getName();
                final Item modifiedItem = function.apply(item);
                character.getItems().set(i, modifiedItem);
                System.out.printf("Item '%s' of character %s was modified to '%s'\n", itemNameBefore,
                        character.getName(), modifiedItem.getName());
            }
        }
        if (!isUpdated) {
            System.out.println("Nothing to update for character items by predicate condition");
        }
    }
}