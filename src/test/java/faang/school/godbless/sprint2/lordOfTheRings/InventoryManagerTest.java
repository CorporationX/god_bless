package faang.school.godbless.sprint2.lordOfTheRings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private InventoryManager manager;
    private Character frodo;
    private Item ring;
    private String result = "";

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
    }

    @Test
    void addItem() {
        String expected = "The One Ring was added to the inventory.";
        manager.addItem(frodo, ring, (item) -> result = item.getName() + " was added to the inventory.");
        assertEquals(expected, result);
        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void removeItem() {
        frodo.getInventory().add(ring);
        frodo.getInventory().add(new Item("Bread", 5));
        assertTrue(manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring")));
        assertFalse(frodo.getInventory().contains(ring));
        assertFalse(manager.removeItem(frodo, (item) -> item.getName().equals("The Ring")));
    }

    @Test
    void isRemoved() {
        assertFalse(manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring")));
    }

    @Test
    void updateItem() {
        frodo.getInventory().add(ring);
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        assertEquals(2000, frodo.getInventory().get(0).getValue());
    }
}