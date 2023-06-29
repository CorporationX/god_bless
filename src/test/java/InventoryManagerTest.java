import faang.school.godbless.sprint3.LordOfTheRings.Character;
import faang.school.godbless.sprint3.LordOfTheRings.InventoryManager;
import faang.school.godbless.sprint3.LordOfTheRings.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private InventoryManager inventoryManager = new InventoryManager();
    private Character tester = new Character("Tester");

    @Test
    public void testAdd() {
        Item ring = new Item("ring", 100);
        inventoryManager.addItem(tester, ring, item -> System.out.println(item.getName()));
        assertEquals(tester.getInventory().get(0), new Item("ring", 100));
    }

    @Test
    public void testRemove() {
        inventoryManager.removeItem(tester, item -> item.getName().equals("ring"));
        assertTrue(tester.getInventory().isEmpty());
    }

    @Test
    public void testUpdate() {
        Item ring = new Item("ring", 100);
        inventoryManager.addItem(tester, ring, item -> System.out.println(item.getName()));
        inventoryManager.updateItem(
                tester,
                item -> item.getName().equals("ring"),
                item -> new Item(item.getName(), 2 * item.getValue()));
        assertEquals(tester.getInventory().get(0), new Item("ring", 200));
    }


}