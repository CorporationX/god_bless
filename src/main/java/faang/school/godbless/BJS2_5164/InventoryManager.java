package faang.school.godbless.BJS2_5164;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
  public void addItem(Character character, Item item, Consumer<Item> addFilter) {
    character.getInventory().add(item);
    addFilter.accept(item);
  }
  public void removeItem(Character character, Predicate<Item> removeFilter) {
    character.getInventory().removeIf(removeFilter);
  }
  public void updateItem(Character character, Predicate<Item> updateFilter, Function<Item, Item> updateFunction) {
    List<Item> items = character.getInventory();
    for (int i = 0; i < items.size(); i++) {
      if (updateFilter.test(items.get(i))) {
        items.set(i, updateFunction.apply(items.get(i)));
      }
    }
  }
}
