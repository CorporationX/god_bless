package faang.school.godbless.sprint2.lordOfTheRings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private InventoryManager manager;
    private Character frodo;
    private Item ring;

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
    }

    @Test
    void addItem() {
        String expected = "The One Ring was added to the inventory.";
        String[] result = {""};
        manager.addItem(frodo, ring, (item) -> result[0] = item.getNAME() + " was added to the inventory.");
        assertEquals(expected, result[0]);
        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void removeItem() {
        frodo.getInventory().add(ring);
        frodo.getInventory().add(new Item("Bread", 5));
        assertTrue(manager.removeItem(frodo, (item) -> item.getNAME().equals("The One Ring")));
        assertFalse(frodo.getInventory().contains(ring));
        assertFalse(manager.removeItem(frodo, (item) -> item.getNAME().equals("The Ring")));
    }

    @Test
    void isRemoved() {
        assertFalse(manager.removeItem(frodo, (item) -> item.getNAME().equals("The One Ring")));
    }

    @Test
    void updateItem() {
        frodo.getInventory().add(ring);
        assertFalse(manager.updateItem(frodo, (item) -> item.getNAME().equals("One Ring"), (item) -> new Item(item.getNAME(), item.getVALUE() * 2)));
        assertTrue(manager.updateItem(frodo, (item) -> item.getNAME().equals("The One Ring"), (item) -> new Item(item.getNAME(), item.getVALUE() * 2)));
        assertEquals(2000, frodo.getInventory().get(0).getVALUE());
    }

    @Test
    void isUpdated() {
        assertFalse(manager.updateItem(frodo, (item) -> item.getNAME().equals("The One Ring"), (item) -> new Item(item.getNAME(), item.getVALUE() * 2)));
    }
}