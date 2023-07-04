package faang.school.godbless.lambda.lords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private Character frodo = new Character("Frodo");
    private Item ring = new Item("The One Ring", 1000);
    private Item panties = new Item("SuperMan", 250);
    InventoryManager manager = new InventoryManager();
    @Test
    void addItemTestNotNull() {
        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " was added to the inventory."));
        assertFalse(frodo.getItemList().isEmpty());
        assertEquals(1, frodo.getItemList().size());
    }
}