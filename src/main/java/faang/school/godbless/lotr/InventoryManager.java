package faang.school.godbless.lotr;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
//    Assumption that nulls are not passed because internal lib
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> newItems = character.getInventory().stream().map(item -> predicate.test(item) ? null : item).filter(Objects::nonNull).toList();;
        character.setInventory(newItems);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> func) {
//        practicing stream api
        List<Item> updatedList = character.getInventory().stream().map(item -> predicate.test(item) ? func.apply(item) : item).toList();
        character.setInventory(updatedList);
    }
}
