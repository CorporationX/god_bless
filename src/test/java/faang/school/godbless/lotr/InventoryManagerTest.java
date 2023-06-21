package faang.school.godbless.lotr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryManagerTest {

    private InventoryManager inventoryManager;
    private Character character;

    @BeforeEach
    void setUp() {
        character = new Character("Grigory");
        inventoryManager = new InventoryManager();
    }

    @Test
    void testRemoveItem_ShouldThrowExceptionIfInventoryIsEmpty() {
        String message = "Inventory is empty";

        assertThrows(IllegalStateException.class, () -> inventoryManager.removeItem(new Character("Frodo"),
                (item) -> item.getName().equals("Coconut")), message);
    }

    @Test
    void testRemoveItem_ShouldRemoveItemFromTheInventoryListAccordingToPassedConditions() {
        Item orange = new Item("Orange", 2);
        character.addItem(orange);
        inventoryManager.removeItem(character, (item) -> item.getName().equals("Coconut"));

        int actualOutput = character.getInventory().size();

        assertEquals(1,actualOutput);
    }

    @Test
    void testUpdateItem_ShouldThrowExceptionIfInventoryIsEmpty() {
        String message = "Inventory is empty";

        assertThrows(IllegalStateException.class, () -> inventoryManager.updateItem(new Character("Frodo"),
                (item) -> item.getName().equals("Coconut"),
                (item) -> new Item(item.getName(), item.getValue() * 2)), message);
    }

    @Test
    void testUpdateItem_ShouldUpdateItemInInventoryAccordingToPassedConditionsAndUpdaterLogic() {
        Item donut = new Item("Donut", 1);
        character.addItem(donut);
        inventoryManager.updateItem(character, (item) -> item.getName().equals("Donut"), (item) -> new Item(item.getName(), item.getValue() * 1000));

        int actualOutput = character.getInventory().get(0).getValue();
        int expectedOutput = 1000;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testAddItem_ShouldThrowExceptionIfInventoryIsFull() {
        String message = "Inventory is full";

        for (int i = 0; i < 30; i++) {
            character.addItem(new Item("Donut", 1));
        }

        assertThrows(IllegalStateException.class, () ->
                inventoryManager.addItem(character, new Item("Orange", 2),
                        (item) -> System.out.println(item.getName() + " was added to the inventory.")), message);
    }

    @Test
    void testAddItem_ShouldAddItemToInventory() {
        Item orange = new Item("Orange", 2);
        inventoryManager.addItem(character, orange,
                (item) -> System.out.println(item.getName() + " was added to the inventory."));

        assertTrue(character.getInventory().contains(orange));
    }
}
