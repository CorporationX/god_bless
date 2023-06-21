package faang.school.godbless.LordOfTheRings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    Character frodo = new Character("Frodo");
    Item ring = new Item("The One Ring", 1000);
    InventoryManager manager = new InventoryManager();

    @BeforeEach
    void setUp(){
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
    }

    @Test
    void testItemUpdated() {
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() + 125));
        Assertions.assertEquals(1125,ring.getValue());
    }

    @Test
    void testItemRemoving() {
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        Assertions.assertFalse(frodo.getInventory().contains(ring));
    }

    @Test
    void testItemAdding() {
        Assertions.assertTrue(frodo.getInventory().contains(ring));
    }
}