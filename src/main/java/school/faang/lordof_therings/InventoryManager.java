package school.faang.lordof_therings;

import school.faang.meta_universe.Consumer;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> collector) {
        character.getInventory().add(item);
        collector.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemRemover) {
        character.getInventory().removeIf(itemRemover);
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> doubler) {
        List<Item> originalList = character.getInventory();
        List<Item> changedList = originalList.stream()
                .filter(filter)
                .map(doubler)
                .toList();
        originalList.removeIf(filter);
        originalList.addAll(changedList);
        character.setInventory(originalList);
    }
}
