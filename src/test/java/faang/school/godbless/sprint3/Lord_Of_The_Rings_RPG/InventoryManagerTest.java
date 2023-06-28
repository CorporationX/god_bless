package faang.school.godbless.sprint3.Lord_Of_The_Rings_RPG;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    Character frodo = new Character("Frodo");
    InventoryManager manager = new InventoryManager();
    Item ring = new Item("The One Ring", 1000);


    @Test
    void InventoryManagerTest() throws Exception {
        manager.addItem(frodo, ring, (item)->System.out.println());
        assertTrue(!frodo.getInventory().isEmpty());
        assertEquals("The One Ring", frodo.getInventory().get(0).getName());
        assertEquals(1000, frodo.getInventory().get(0).getValue());

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        assertEquals(2000, frodo.getInventory().get(0).getValue());

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        assertTrue(frodo.getInventory().isEmpty());
    }

    @Test
    void testInventoryManagerException(){
        manager.addItem(frodo, ring, (item)->System.out.println());

        Exception thrownUpdate = Assertions.assertThrows(Exception.class, () -> {
            manager.updateItem(frodo, (item) -> item.getName().equals("Fail test"), (item) -> new Item(item.getName(), item.getValue() * 2));
        });
        Assertions.assertEquals("Item is not was found, item is not be updated", thrownUpdate.getMessage());

        Exception thrownRemove = Assertions.assertThrows(Exception.class, () -> {
            manager.removeItem(frodo, (item) -> item.getName().equals("Fail test"));
        });
        Assertions.assertEquals("Item is not was found, item is not be removed", thrownRemove.getMessage());

    }
}