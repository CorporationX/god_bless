package faang.school.godbless.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void addItemTest() {
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void removeItemTest() {
        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        assertFalse(frodo.getInventory().contains(ring));
    }

    @Test
    void updateItemTest() {
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        assertEquals("The One Ring", frodo.getInventory().get(0).getName());
        assertEquals(2000, frodo.getInventory().get(0).getValue());
    }
}