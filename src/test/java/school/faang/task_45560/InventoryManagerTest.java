package school.faang.task_45560;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private static final String wasAddToInventory = " был добавлен в инвентарь.";
    private InventoryManager manager;
    private Character frodo;
    private Item ring;
    private Item necklace;

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        necklace = new Item("The Necklace", 1340);
    }

    @Test
    void testSuccessAddItem() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + wasAddToInventory));

        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void testSuccessRemoveItem() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + wasAddToInventory));
        manager.addItem(frodo, necklace, (item) -> System.out.println(item.getName() + wasAddToInventory));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        assertTrue(frodo.getInventory().contains(necklace));
        assertFalse(frodo.getInventory().contains(ring));
    }

    @Test
    void testRemoveItemIfItemDoesNotPassThroughFilter() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + wasAddToInventory));
        manager.addItem(frodo, necklace, (item) -> System.out.println(item.getName() + wasAddToInventory));

        manager.removeItem(frodo, (item) -> item.getName().equals("wrong name"));

        assertTrue(frodo.getInventory().contains(necklace));
        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void testRemoveItemIfInventoryIsEmpty() {
        manager.removeItem(frodo, (item) -> item.getName().equals("wrong name"));

        assertTrue(frodo.getInventory().isEmpty());
    }

    @Test
    void testSuccessUpdateItem() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + wasAddToInventory));
        manager.updateItem(frodo,
            (item) -> item.getName().equals("The One Ring"),
            (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        assertTrue(frodo.getInventory().contains(ring));
        assertEquals(2000, frodo.getInventory().get(0).getValue());
    }

    @Test
    void testUpdateItemIfInventoryIsEmpty() {
        manager.updateItem(frodo,
            (item) -> item.getName().equals("The One Ring"),
            (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        assertTrue(frodo.getInventory().isEmpty());
    }

    @Test
    void testUpdateItemIfItemDoesNotPassThroughFilter() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + wasAddToInventory));
        manager.updateItem(frodo,
            (item) -> item.getName().equals("The"),
            (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        assertEquals(ring.getValue(), frodo.getInventory().get(0).getValue());
    }
}