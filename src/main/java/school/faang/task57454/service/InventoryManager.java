package school.faang.task57454.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {
    public void addItem(Character pers, Item item, Consumer<Item> consumer) {
        pers.getInventory().add(item);
        consumer.accept(item);
    }

    public List<Item> removeItem(Character pers, Predicate<Item> condition) {
        List<Item> removeItems = new ArrayList<>();
        List<Item> inventory = pers.getInventory();
        inventory.removeIf(condition::test);
        return removeItems;
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        character.setInventory(
                character.getInventory().stream()
                        .map(item -> predicate.test(item) ? updater.apply(item) : item)
                        .collect(Collectors.toList())
        );
    }
}
