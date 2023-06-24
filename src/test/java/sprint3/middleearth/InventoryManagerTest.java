package sprint3.middleearth;

import sprint3.lambda.middleearth.Character;
import sprint3.lambda.middleearth.InventoryManager;
import sprint3.lambda.middleearth.Item;
import sprint3.lambda.middleearth.exception.InventoryLimitIsExceededException;
import sprint3.lambda.middleearth.exception.NoItemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InventoryManagerTest {
    private final InventoryManager manager = new InventoryManager();
    private final Character character = new Character("Oleg");
    private final Item ring = new Item("The one ring", 1000);

    @Test
    public void shouldNotThrowException() {
        Assertions.assertDoesNotThrow(() -> manager.addItem(character, ring, (item) ->
                System.out.println(item.getName() + " was added to the inventory.")));

        Assertions.assertDoesNotThrow(() -> manager.updateItem(character, (item) -> item.getName().equals("The one ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2)));

        Assertions.assertDoesNotThrow(() -> manager.removeItem(character, (item) ->
                item.getName().equals("The one ring")));
    }

    @Test
    public void shouldThrowException() {
        fillInventory();
        Assertions.assertThrows(InventoryLimitIsExceededException.class, () ->
                manager.addItem(character, ring, (item) -> System.out.println(item.getName() + " was added to the inventory.")));

        Assertions.assertThrows(NoItemException.class, () ->
                manager.updateItem(character, (item) -> item.getName().equals("The one ring"),
                        (item) -> new Item(item.getName(), item.getValue() * 2)));

        Assertions.assertThrows(NoItemException.class, () ->
                manager.removeItem(character, (item) -> item.getName().equals("The one ring")));
    }

    @Test
    public void shouldIncreaseSizeOfInventory() {
        int expectedSize = 20;
        Item newBackpack = new Item("Backpack extender", 15000);

        character.inventoryUpgrade(newBackpack, (item) -> item.getName().equals("Backpack extender"));

        Assertions.assertEquals(expectedSize, character.getMaxInventorySize());
    }

    private void fillInventory() {
        for (int i = 0; i < character.getMaxInventorySize(); i++) {
            character.getInventory().add(new Item(String.valueOf(i), i * 10));
        }
    }
}
