package school.faang.lostoftheringsrpg.main_code;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Item item, Character character, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           int newValue) {

          List<Item> items = character.getInventory();

          for (Item item : items) {
              if (predicate.test(item)) {
                  item.setValue(newValue);
              }
          }
    }
}
