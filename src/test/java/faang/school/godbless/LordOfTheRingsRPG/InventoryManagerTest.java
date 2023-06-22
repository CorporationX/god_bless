package faang.school.godbless.LordOfTheRingsRPG;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    Character frodo;
    Item ring;
    InventoryManager manager;

    @BeforeEach
    public void init() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        manager = new InventoryManager();
        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item + " was added to the inventory."));
    }

    @Test
    public void addItemTest() {
        String expected = "The One Ring";
        String result = frodo.getInventory().get(0).getName();
        assertEquals(expected, result);
    }

    @Test
    public void removeItemTest() {
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        assertEquals(0, frodo.getInventory().size());
    }

    @Test
    public void updateItemTest() {
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        assertEquals(2000, frodo.getInventory().get(0).value);
    }
}