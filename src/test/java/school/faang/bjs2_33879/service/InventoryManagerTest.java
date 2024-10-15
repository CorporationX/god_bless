package school.faang.bjs2_33879.service;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_33879.constants.ErrMessageValidate;
import school.faang.bjs2_33879.model.Character;
import school.faang.bjs2_33879.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
        IllegalArgumentException exceptionCharacterNull = assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.addItem(null, amulet, additionalAction));
        assertEquals(ErrMessageValidate.CHARACTER_IS_NULL, exceptionCharacterNull.getMessage());

        IllegalArgumentException exceptionItemNull = assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.addItem(alaric, null, additionalAction));
        assertEquals(ErrMessageValidate.ITEM_IS_NULL, exceptionItemNull.getMessage());

        IllegalArgumentException exceptionAdditionalActionNull = assertThrows(IllegalArgumentException.class,
                () -> inventoryManager.addItem(alaric, amulet, null));
        assertEquals(ErrMessageValidate.ADDITIONAL_ACTION_IS_NULL, exceptionAdditionalActionNull.getMessage());

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

        inventoryManager.addItem(alaric, amulet, System.out::println);

        Predicate<Item> removeConditionFalse = item -> item.getValue() < 1000;
        //TODO: Сделать проверку исключений
        List<Item> inventory = alaric.getInventory();
        inventoryManager.removeItem(alaric,amulet,removeConditionFalse);
        assertFalse(inventory.isEmpty());

        Predicate<Item> removeConditionTrue = item -> item.getValue() > 1000;
        Item amuletForRemove = inventory.get(0);
        inventoryManager.removeItem(alaric, amuletForRemove, removeConditionTrue);
        assertTrue(inventory.isEmpty());


    }

    @Test
    void updateItem() {
        //TODO: Сделать проверку исключений
        //TODO: Сделать проверку логики

    }
}