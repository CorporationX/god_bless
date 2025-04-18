package school.faang.bjs2_71163;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        if (character == null) {
            throw new ParamsInInventoryManagerIsNullException("Character is null");
        }
        boolean isAdd = character.getItems().add(item);
        if (!isAdd) {
            throw new ItemAlreadyExistsException(String.format("Item %s already exists", item.name()));
        }
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> ifContains) {
        if (character == null) {
            throw new ParamsInInventoryManagerIsNullException("Character is null");
        }
        character.getItems().removeIf(ifContains);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        if (character == null) {
            throw new ParamsInInventoryManagerIsNullException("Character is null");
        }
        Stream<Item> filteredStream =  character.getItems().stream()
                .filter(itemPredicate)
                .map(itemFunction);
        Stream<Item> unfilteredStream =  character.getItems().stream()
                .filter(itemPredicate.negate());

        Set<Item> updatedItems = Stream.concat(filteredStream, unfilteredStream)
                .collect(Collectors.toSet());

        character.getItems().clear();
        character.getItems().addAll(updatedItems);
    }
}
