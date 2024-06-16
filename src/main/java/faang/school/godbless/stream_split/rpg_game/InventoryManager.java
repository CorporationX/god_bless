package faang.school.godbless.stream_split.rpg_game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public Character addItem(Character ch, Item item, Consumer<Item> consumer) {
        List<Item> items = new ArrayList<>();
        items.add(item);

        consumer.accept(item);

        return new Character(ch.name(), items);
    }

    public void removeItem(Character ch, Predicate<Item> pred) {
        ch.inventory().removeIf(pred);
    }

    public void updateItem(Character ch, Predicate<Item> pred, Function<Item, Item> update) {
        ch.inventory().replaceAll(item -> pred.test(item) ? update.apply(item) : item);
    }
}