package school.faang.godbless.bjs2_33592;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {

  public void addItem(Character character, Item item, Consumer<Item> additionalAction) {
    character.getInventory().add(item);
    additionalAction.accept(item);
  }

  public void removeItem(Character character, Predicate<Item> predicate) {
    character.getInventory().removeIf(predicate);
  }

  public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> action) {
    character.setInventory(
        character.getInventory().stream().map(i -> predicate.test(i) ? action.apply(i) : i).toList());
  }
}
