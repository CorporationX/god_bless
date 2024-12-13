package school.faang.task_45584;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryManagerTest {
    private InventoryManager inventoryManager;
    private Character frodo;

    @BeforeEach
    void setUp() {
        inventoryManager = new InventoryManager();
        frodo = new Character("Frodo");
    }

    @Test
    void testAddItem() {
        Item ring = new Item("Ring", ItemCategory.RING, 100);
        List<Item> expectedInventory = List.of(ring);

        inventoryManager.addItem(frodo, ring, item -> System.out.println(item.name()
                + " был добавлен в инвентарь"));

        assertEquals(expectedInventory, frodo.getInventory());
    }

    @Test
    void testRemoveItem() {
        Item ring = new Item("Ring", ItemCategory.RING, 100);
        inventoryManager.addItem(frodo, ring, item -> System.out.println(item.name()
                + " был добавлен в инвентарь"));

        inventoryManager.removeItem(frodo, item -> item.category().equals(ItemCategory.RING));

        assertEquals(0, frodo.getInventory().size());
    }

    @Test
    void testUpdateItem() {
        Item ring = new Item("Ring", ItemCategory.RING, 100);
        inventoryManager.addItem(frodo, ring, item  -> System.out.println(item.name()
                + " был добавлен в инвентарь"));

        inventoryManager.updateItem(frodo, item -> item.name().equals("Ring"),
                item -> new Item(item.name(), item.category(), item.value() * 2));

        Item expectedItem = new Item(ring.name(), ring.category(), ring.value() * 2);
        assertEquals(expectedItem, frodo.getInventory().get(0));
    }
}