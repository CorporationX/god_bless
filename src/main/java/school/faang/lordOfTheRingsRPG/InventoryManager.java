package school.faang.lordOfTheRingsRPG;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
  public void addItem(Character character, Item item, Consumer<Item> consumer) {
    consumer.accept(item);
    character.getInventory().add(item);
  }

  public void removeItem(Character character, Predicate<Item> predicate) {
    character.setInventory(
        new ArrayList<>(character.getInventory().stream()
            .filter(predicate.negate())
            .toList())
    );
  }

  public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
    character.setInventory(
        new ArrayList<>(character.getInventory().stream()
            .map(item -> predicate.test(item) ? function.apply(item) : item)
            .toList())
    );
  }
}
