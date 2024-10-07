import org.junit.jupiter.api.Test;
import school.faang.lordOfTheRings.Character;
import school.faang.lordOfTheRings.InventoryManager;
import school.faang.lordOfTheRings.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryManagerTest {
    private static final InventoryManager inventoryManager = new InventoryManager();
    private static final Consumer<Item> handler =
            (item) -> System.out.println(item.getName() + " was added to inventory.");
    private static final Predicate<Item> filter =
            (item) -> item.getValue() > 500;
    private static final Function<Item, Item> function =
            (item) -> new Item(item.getName(), item.getValue() / 5);

    @Test
    public void testAddMultipleItems() {
        // arrange
        Character frodo = new Character("Frodo Benkins");
        Item ring = new Item("The one Ring", 500);
        Item sword = new Item("Legendary Sword", 1000);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("The one Ring", 500);
        expected.put("Legendary Sword", 1000);
        Map<String, Integer> actual = new HashMap<>();

        // act
        inventoryManager.addItem(frodo, ring, handler);
        inventoryManager.addItem(frodo, sword, handler);
        frodo.getInventory().forEach(item -> actual.put(item.getName(), item.getValue()));

        // assert
        assertEquals(expected, actual, "Should add ring and sword with their names and values.");
    }

    @Test
    public void testAddMultipleAndFilterThem() {
        // arrange
        Character frodo = new Character("Frodo Benkins");
        Item ring = new Item("The one Ring", 500);
        Item sword = new Item("Legendary Sword", 1000);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("The one Ring", 500);
        Map<String, Integer> actual = new HashMap<>();

        // act
        inventoryManager.addItem(frodo, ring, handler);
        inventoryManager.addItem(frodo, sword, handler);
        inventoryManager.removeItem(frodo, filter);
        frodo.getInventory().forEach(item -> actual.put(item.getName(), item.getValue()));

        // assert
        assertEquals(expected, actual, "Sword should be removed due to it's price.");
    }

    @Test
    public void testUpdateDifferentItems() {
        // arrange
        Character frodo = new Character("Frodo Benkins");
        Item ring = new Item("The one Ring", 500);
        Item necklace = new Item("King's necklace", 700);
        Item sword = new Item("Legendary Sword", 1000);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("The one Ring", 500);
        expected.put("King's necklace", 700 / 5);
        expected.put("Legendary Sword", 1000 / 5);
        Map<String, Integer> actual = new HashMap<>();

        // act
        inventoryManager.addItem(frodo, ring, handler);
        inventoryManager.addItem(frodo, necklace, handler);
        inventoryManager.addItem(frodo, sword, handler);
        inventoryManager.updateItem(frodo, filter, function);
        frodo.getInventory().forEach(item -> actual.put(item.getName(), item.getValue()));

        // assert
        assertEquals(expected, actual,
                "Ring price value should remain the same, while necklace&sword should cost 5 times less");
    }
}