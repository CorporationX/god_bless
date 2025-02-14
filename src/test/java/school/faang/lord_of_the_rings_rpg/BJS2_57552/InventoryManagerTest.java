package school.faang.lord_of_the_rings_rpg.BJS2_57552;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryManagerTest {
    private Item sword;
    private Character conanTheBarbarian;
    private InventoryManager inventoryManager;

    @BeforeEach
    void setUp() {
        sword = new Item("Sword", 50000);
        conanTheBarbarian = new Character();
        inventoryManager = new InventoryManager();

        inventoryManager.addItem(
                conanTheBarbarian,
                sword,
                (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
    }

    @Test
    void TestAddItem() {
        assertEquals(sword, conanTheBarbarian.getInventory().get(0));
    }

    @Test
    void TestRemoveItem() {
        inventoryManager.removeItem(conanTheBarbarian, (item) -> item.getName().equals("Sword"));

        assertTrue(conanTheBarbarian.getInventory().isEmpty());
    }

    @Test
    void TestUpdateItem() {
        inventoryManager.updateItem(
                conanTheBarbarian,
                (item) -> item.getName().equals("Sword"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
        assertEquals(100000, conanTheBarbarian.getInventory().get(0).getValue());
    }
}