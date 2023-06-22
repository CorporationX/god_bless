package faang.school.godbless.lordOfTheRings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void testAdditionItem() {
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        List<Item> expected = List.of(new Item("The One Ring", 1000));

        assertEquals(1, frodo.getInventory().size());
        assertEquals(expected, frodo.getInventory());
    }

    @Test
    public void testRemovingItem() {
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        List<Item> expected = new ArrayList<>();

        assertEquals(0, frodo.getInventory().size());
        assertEquals(expected, frodo.getInventory());
    }

    @Test
    public void testUpdatingItem() {
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(),
                item.getValue() * 2));

        List<Item> expected = List.of(new Item("The One Ring", 2000));

        assertEquals(1, frodo.getInventory().size());
        assertEquals(expected, frodo.getInventory());
    }
}