package faang.school.godbless.secondSprint.LordOfTheRings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    Character frodo;
    Item ring;
    InventoryManager inventoryManager;

    @BeforeEach
    public void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        inventoryManager = new InventoryManager();
        inventoryManager.addItem(frodo, ring, item -> System.out.println("Теперь у вас есть " + item.getName()));
    }

    @Test
    public void testAddItem() {
        String expected = "The One Ring";
        String result = frodo.getInventory().get(0).getName();

        assertEquals(expected, result);
    }

    @Test
    public void testRemoveItem() {
        inventoryManager.removeItem(frodo, item -> item.getValue() == 1000);

        assertEquals(0, frodo.getInventory().size());
    }

    @Test
    public void testUpdateItem() {
        inventoryManager.updateItem(frodo, item -> "The One Ring".equals(item.getName()), item ->
                new Item(item.getName(), item.getValue() * 2));

        assertEquals(1, frodo.getInventory().size());
        assertEquals(2000, frodo.getInventory().get(0).getValue());
    }
}