package faang.school.godbless.bjs2_5020;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

@Slf4j
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        Optional<Item> item = character.getInventory().stream()
                .filter(filter)
                .findAny();
        item.ifPresent(value -> character.getInventory().remove(value));
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> function) {
        List<Item> charItems = character.getInventory();
        OptionalInt itemIndex = IntStream.range(0, charItems.size())
                .filter(i -> filter.test(charItems.get(i)))
                .findFirst();
        if (itemIndex.isPresent()) {
            Item item = charItems.get(itemIndex.getAsInt());
            charItems.set(itemIndex.getAsInt(), function.apply(item));
        } else {
            log.info("No one item was updated in inventory");
        }
    }
}
