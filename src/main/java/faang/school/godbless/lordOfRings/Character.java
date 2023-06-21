package faang.school.godbless.lordOfRings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Character {
  private List<Item> inventory = new ArrayList<>();
  private String name;

  public Character(String name) {
    this.name = name;
  }

  public List<Item> getInventory() {
    return inventory;
  }

  public void addItem(Item item) {
    inventory.add(item);
  }

  public void removeItem(Predicate<Item> predicate) {
    Optional<Item> candidate = inventory.stream().filter(predicate).findFirst();
    candidate.ifPresent(item -> inventory.remove(item));
  }

  public void updateItem(Predicate<Item> predicate, Function<Item, Item> getUpdatedValue) {
    for (int i =0; i < inventory.size(); i++) {
      if (predicate.test(inventory.get(i))) {
        inventory.set(i, getUpdatedValue.apply(inventory.get(i)));
      }
    }
  }
}
