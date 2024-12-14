package faang.school.godbless.BJS2_9047;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
  public void addItem(Character character, Item item, Consumer<Item> comment) {
    character.getInventory().add(item);
    comment.accept(item);
  }

  public void removeItem(Character character, Predicate<Item> filterFromRemove) {
    character.getInventory().removeIf(filterFromRemove);
  }

  public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> changeFunction) {
    character.getInventory().replaceAll(item -> filter.test(item) ? changeFunction.apply(item) : item);
  }
}
