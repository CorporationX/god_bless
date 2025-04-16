package school.faang.bjs270086;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class InventoryManagerTest {
    @Test
    void testAddItem() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (character, item) -> {});

        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void testRemoveItems() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (character, item) -> {});

        manager.removeItems(frodo, (item) -> item.getName().contains("Ring"));

        assertFalse(frodo.getInventory().contains(ring));
    }

    @Test
    void testUpdateItems() {
        Character frodo = new Character("Frodo");
        String ringName = "The One Ring";
        Item ring = new Item(ringName, 1000);
        int newPrice = ring.getPrice() * 2;
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (character, item) -> {});

        manager.updateItems(
                frodo,
                (item) -> item.getName().equals(ringName),
                (item) -> item.setPrice(item.getPrice() * 2)
        );

        assertEquals(newPrice, ring.getPrice());
    }
}