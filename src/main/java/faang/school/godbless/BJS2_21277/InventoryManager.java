package faang.school.godbless.BJS2_21277;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
@Getter
public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        List<Item> updatedInventory = character.getInventory().stream().map(item -> itemPredicate.test(item) ? itemFunction.apply(item) : item).toList();
        character.getInventory().clear();
        character.getInventory().addAll(updatedInventory);
    }
}
