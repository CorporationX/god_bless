package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class InventoryManagerTest {

    Character frodo;
    Item ring, sword, cloak;
    InventoryManager manager;
    @BeforeEach
    public void onSet() {
        frodo = new Character();
        ring = new Item("The one ring", 1000);
        sword = new Item("String", 500);
        cloak = new Item("Elven Cloak", 300);
        manager = new InventoryManager();
    }

    @Test
    public void addItemTest() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        assertEquals(1, frodo.getInventory().size());
    }

    @Test
    public void addSeveralItemsAndDeleteTest() {
        manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, cloak, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.removeItem(frodo, (item) -> item.getName().equals("String"));
        assertEquals(1, frodo.getInventory().size());
    }

    @Test
    public void updateItemTest() {
        manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, cloak, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.updateItem(frodo, (item) -> item.getName().equals("String"), (item) -> new Item(item.getName(), item.getValue() * 2));
        assertEquals(2, frodo.getInventory().size());
        assertEquals(1000, frodo.getInventory().get(0).getValue());
        assertEquals(300, frodo.getInventory().get(1).getValue());
    }
}