package school.faang.lambda.bjs2_87308;

import lombok.NonNull;

import java.util.Iterator;
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

    public void removeItem(@NonNull Character character, @NonNull Item item, Predicate<Item> predicate) {
        if (predicate.test(item)) {
            if (!character.getItems().contains(item)) {
                System.out.printf("Nothing to remove. Character %s doesnt have item %s\n",
                        character.getName(), item.getName());
                return;
            }
            character.getItems().remove(item);
            System.out.printf("Item %s was removed from character %s\n", item.getName(), character.getName());
        } else {
            System.out.printf("Item %s wasnt removed. Does not fit the condition\n", item.getName());
        }
    }

    public void updateItem(@NonNull Character character, @NonNull Item item, Function<Item, Item> function) {
        if (!character.getItems().contains(item)) {
            System.out.printf("Nothing to update. Character %s doesnt have item %s\n",
                    character.getName(), item.getName());
            return;
        }

        Iterator<Item> iterator = character.getItems().iterator();
        while (iterator.hasNext()) {
            Item next = iterator.next();
            if (next.equals(item)) {
                String itemBefore = next.getName();
                iterator.remove();
                character.getItems().add(function.apply(item));
                System.out.printf("Item '%s' of character %s was modified to '%s'\n", itemBefore, character.getName(),
                        item.getName());
                break;
            }
        }
    }
}