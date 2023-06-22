package faang.school.godbless.sprint3.rings_lord;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private Character frodo;
    private Item ring;
    private InventoryManager manager;

    @BeforeEach
    void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        manager = new InventoryManager();
    }


    @Test
    void addItem_shouldAddSpecifyItem() {
        assertTrue(frodo.getInventory().isEmpty());

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        assertAll(() -> {
            assertEquals(frodo.getInventory().size(), 1);
            assertEquals(frodo.getInventory().get(0), ring);
        });
    }

    @Test
    void removeItem_shouldRemoveSpecifyItem() {
        frodo.getInventory().add(ring);
        assertEquals(frodo.getInventory().size(), 1);

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        assertTrue(frodo.getInventory().isEmpty());
    }

    @Test
    void updateItem_shouldIncreaseItemValue() {
        frodo.getInventory().add(ring);
        assertEquals(frodo.getInventory().get(0).getValue(), 1000);

        manager.updateItem(
                frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        assertAll(() -> {
            assertEquals(frodo.getInventory().size(), 1);
            assertEquals(frodo.getInventory().get(0).getValue(), 2000);
        });
    }
}