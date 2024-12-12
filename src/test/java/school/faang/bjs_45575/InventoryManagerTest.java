package school.faang.bjs_45575;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class InventoryManagerTest {

    @Test
    void addItem() {
        InventoryManager inventoryManager = new InventoryManager();
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        Assertions.assertTrue(frodo.getInventory().isEmpty());

        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName()
                + "  was added to the inventory."));

        Assertions.assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    void removeItem() {
        InventoryManager inventoryManager = new InventoryManager();
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName()
                + "  was added to the inventory."));

        Assertions.assertTrue(frodo.getInventory().contains(ring));

        boolean removeResult = inventoryManager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        Assertions.assertTrue(removeResult);
        Assertions.assertFalse(frodo.getInventory().contains(ring));
        Assertions.assertEquals(0, frodo.getInventory().size());
    }

    @Test
    void updateItem() {
        InventoryManager inventoryManager = new InventoryManager();
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName()
                + "  was added to the inventory."));

        Assertions.assertTrue(frodo.getInventory().contains(ring));

        long resultUpdate = inventoryManager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        Assertions.assertEquals(1, resultUpdate);
        Assertions.assertEquals(2000, frodo.getInventory().get(0).getValue());
        Assertions.assertEquals(1, frodo.getInventory().size());
    }

}