package faang.school.godbless.lordOfRings;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
  public void addItem(Character character, Item item, Consumer<Item> callback) {
    character.addItem(item);
    callback.accept(item);
  }

  public void removeItem(Character character, Predicate<Item> predicate) {
    character.removeItem(predicate);
  }

  public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> getUpdatedItem) {
    character.updateItem(predicate, getUpdatedItem);
  }

  public List<Item> getInventory(Character character) {
    return character.getInventory();
  }
}
