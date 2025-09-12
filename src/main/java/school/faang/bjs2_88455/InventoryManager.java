package school.faang.bjs2_88455;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumerAdd) {
        character.getInventory().add(item);
        consumerAdd.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicateFilter) {
        character.getInventory().removeIf(predicateFilter);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> inventory = Stream.concat(
                character.getInventory().stream()
                        .filter(predicate)
                        .map(function),
                 character.getInventory().stream()
                         .filter(predicate.negate())
                         .map(item -> new Item(item.getName(), item.getValue()))
        ).toList();

       // System.out.println(inventory);
    }

    public void printAllItems(Character character, Consumer<ArrayList<Item>> consumer) {
        System.out.printf("All items %s-", character.getName());
        consumer.accept(character.getInventory());
    }
}
