package faang.school.godbless.lordOfRingTest;

import faang.school.godbless.sprint2.lordoftheRings.Character;
import faang.school.godbless.sprint2.lordoftheRings.InventoryManager;
import faang.school.godbless.sprint2.lordoftheRings.Item;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest {
    Character frodo;
    Item ring;
    InventoryManager inventoryManager;
    @BeforeEach
    public void init() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        inventoryManager = new InventoryManager();
        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item + " was added to the inventory."));
    }

    @Test
    public void addItemTest() {
        String expected = "The One Ring";
        String result = frodo.getInventory().get(0).getName();
        assertEquals(expected,result);
    }
    @Test
    public void deleteItemTest(){
        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        assertEquals(0, frodo.getInventory().size());
    }
    @Test
    public void updateItemTest(){
        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        assertEquals(2000, frodo.getInventory().get(0).getValue());
    }
}
