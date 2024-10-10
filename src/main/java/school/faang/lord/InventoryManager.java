package school.faang.lord;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

  public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
    character.getInventory().add(item);
    itemConsumer.accept(item);
  }

  public void removeItem(Character character, Predicate<Item> itemPredicate) {
    List<Item> items = character.getInventory();
    int index = 0;
    for (Item item : items) {
      if (itemPredicate.test(item)) {
        index = items.indexOf(item);
      }
    }
    items.remove(index);
  }

  public void updateItem(Character character, Predicate<Item> itemPredicate,
      Function<Item, Item> itemFunction) {
    List<Item> items = character.getInventory();
    for (Item item : items) {
      if (itemPredicate.test(item)) {
        Item updatedItem = itemFunction.apply(item);
        item.setValue(updatedItem.getValue());
        item.setName(updatedItem.getName());
        return;
      }
    }
  }

}
