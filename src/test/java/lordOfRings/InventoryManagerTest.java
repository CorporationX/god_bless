package lordOfRings;

import faang.school.godbless.lordOfRings.InventoryManager;
import faang.school.godbless.lordOfRings.Item;
import faang.school.godbless.lordOfRings.Character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryManagerTest {
  private Character frodo = new Character("Frodo");
  private InventoryManager manager;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    manager = new InventoryManager();
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void addItemTest() {
    Item ring = new Item("The One Ring", 1000);

    manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    assertEquals("The One Ring was added to the inventory.", outputStreamCaptor.toString()
        .trim());

    outputStreamCaptor.reset();;

    Item shield = new Item("The Shield", 500);
    manager.addItem(frodo, shield, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    assertEquals("The Shield was added to the inventory.", outputStreamCaptor.toString()
        .trim());
  }
  @Test
  public void removeItemTest() {
    Item ring = new Item("The One Ring", 1000);
    Item shield = new Item("The Gun", 1500);
    Item gun = new Item("The Shield", 500);

    manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    manager.addItem(frodo, shield, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    manager.addItem(frodo, gun, (item) -> System.out.println(item.getName() + " was added to the inventory."));

    outputStreamCaptor.reset();;

    // Удаляем предмет из инвентаря
    manager.removeItem(frodo, (item) -> item.getName().equals("The Gun"));

    assertEquals(2, frodo.getInventory().size());
  }
  @Test
  public void updateItemTest() {
    Item ring = new Item("The One Ring", 1000);
    Item shield = new Item("The Gun", 1500);
    Item gun = new Item("The Shield", 500);

    manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    manager.addItem(frodo, shield, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    manager.addItem(frodo, gun, (item) -> System.out.println(item.getName() + " was added to the inventory."));

    manager.updateItem(frodo, (item) -> item.getName().equals(shield.getName()), (item) -> new Item(item.getName(), item.getValue() * 2));
    assertEquals(shield.getValue() * 2, manager.getInventory(frodo).get(1).getValue());
  }
}
