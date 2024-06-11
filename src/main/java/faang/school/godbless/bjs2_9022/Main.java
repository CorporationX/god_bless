package faang.school.godbless.bjs2_9022;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

  private static final int VALUE_DOUBLE = 2;

  public static void main(String[] args) {
    Consumer consumer = item -> System.out.println(item + " was added to the inventory.");
    BiPredicate<Item, Item> biPredicate = (item, curItem) -> item.getName().equals(curItem.getName());
    Function<Item, Integer> function = item -> item.getValue() * VALUE_DOUBLE;

    Character frodo = new Character("Frodo");
    Character gollum = new Character("Gollum");
    Character legolas = new Character("Legolas");
    Item ring = new Item("The One Ring", 1000);
    Item dagger = new Item("The dagger", 100);
    Item bow = new Item("The bow", 500);

    InventoryManager inventoryManager = new InventoryManager();

    inventoryManager.addItem(frodo, ring, consumer);
    inventoryManager.addItem(gollum, ring, consumer);
    inventoryManager.addItem(legolas, bow, consumer);
    inventoryManager.addItem(legolas, dagger, consumer);

    inventoryManager.removeItem(frodo, ring, biPredicate);

    inventoryManager.updateItem(gollum, ring, biPredicate, function);
    inventoryManager.updateItem(legolas, dagger, biPredicate, function);

    legolas.getInventory().forEach(item -> System.out.println(item.getName() + " - " + item.getValue()));

  }

}
