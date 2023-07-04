package main.java.faang.school.godbless.sprint3_lambda.rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> items = character.getInventory();
        items.stream().filter(predicate).findFirst().ifPresent(items::remove);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                function.apply(item);
                character.getInventory().set(character.getInventory().indexOf(item), item);
            }
        }
    }
}
