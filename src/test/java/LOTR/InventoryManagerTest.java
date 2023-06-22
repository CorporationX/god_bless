package LOTR;

import faang.school.godbless.LOTR.Character;
import faang.school.godbless.LOTR.InventoryManager;
import faang.school.godbless.LOTR.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InventoryManagerTest {
    @Test
    void manageTest() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        assertNotNull(frodo.getInventory());

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        assertEquals(0, frodo.getInventory().size());


// Обновляем предмет в инвентаре
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        assertNotNull(frodo.getInventory());
        assertEquals(2000, frodo.getInventory().get(0).getValue());

    }
}
