package school.faang.bjs2_33879.service;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_33879.model.Character;
import school.faang.bjs2_33879.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private final InventoryManager inventoryManager = new InventoryManager();

    @Test
    void addItem() {
        Character alaric = new Character("Alaric");
        alaric.setInventory(new ArrayList<>());
        Item amulet = new Item("Amulet of the Fallen King", 1500);
        Consumer<Item> additionalAction = System.out::println;

        List<Item> itemsCorrectResult = List.of(amulet);
        inventoryManager.addItem(alaric, amulet, additionalAction);
        assertEquals(itemsCorrectResult, alaric.getInventory());

        List<Integer> listForTestAdditionalAction = new ArrayList<>();
        List<Integer> correctResultListForAdditionalAction = List.of(1);

        Consumer<Item> additionalActionForTestAdditionalAction = item -> listForTestAdditionalAction.add(1);
        inventoryManager.addItem(alaric, amulet, additionalActionForTestAdditionalAction);
        assertEquals(correctResultListForAdditionalAction, listForTestAdditionalAction);
    }

    @Test
    void removeItem() {
        Character alaric = new Character("Alaric");
        Item amulet = new Item("Amulet of the Fallen King", 1500);
        Predicate<Item> removeConditionFalse = item -> item.getValue() < 1000;

        inventoryManager.addItem(alaric, amulet, System.out::println);

        Character testCharacterInventoryNull = new Character("Test");
        IllegalStateException exceptionInventoryNull = assertThrows(IllegalStateException.class,
                () -> inventoryManager.removeItem(testCharacterInventoryNull, amulet, removeConditionFalse));
        assertEquals("list items cannot be null", exceptionInventoryNull.getMessage());

        List<Item> inventory = alaric.getInventory();
        inventoryManager.removeItem(alaric, amulet, removeConditionFalse);
        assertFalse(inventory.isEmpty());

        Predicate<Item> removeConditionTrue = item -> item.getValue() > 1000;
        Item amuletForRemove = inventory.get(0);
        inventoryManager.removeItem(alaric, amuletForRemove, removeConditionTrue);
        assertTrue(inventory.isEmpty());


    }

    @Test
    void updateItem() {
        Character alaric = new Character("Alaric");
        Item amulet = new Item("Amulet of the Fallen King", 1500);
        Item amuletCorrectResult = new Item("Amulet of the Fallen King", 3000);
        Predicate<Item> updConditionTrue = item -> item.getValue() > 1000;
        Predicate<Item> updConditionFalse = item -> item.getValue() > 2000;
        Function<Item, Item> updateAction = item -> new Item(item.getName(), item.getValue() * 2);

        inventoryManager.addItem(alaric, amulet, System.out::println);

        Character testCharacterInventoryNull = new Character("Test");
        IllegalStateException exceptionInventoryNull = assertThrows(IllegalStateException.class,
                () -> inventoryManager.updateItem(testCharacterInventoryNull, updConditionTrue, updateAction));
        assertEquals("list items cannot be null", exceptionInventoryNull.getMessage());

        List<Item> inventory = alaric.getInventory();

        inventoryManager.updateItem(alaric, updConditionFalse, updateAction);
        Item amuletResultForConditionFalse = inventory.get(0);
        assertEquals(amulet, amuletResultForConditionFalse);

        inventoryManager.updateItem(alaric, updConditionTrue, updateAction);
        Item amuletResultForConditionTrue = inventory.get(0);
        assertEquals(amuletCorrectResult, amuletResultForConditionTrue);
    }
}