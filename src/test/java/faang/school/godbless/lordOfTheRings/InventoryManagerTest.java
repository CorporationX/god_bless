package faang.school.godbless.lordOfTheRings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private InventoryManager manager;
    private Character character;
    private Item stick;
    private Item stick2;
    private Item sword;
    private Consumer<Item> consumer;
    private Predicate<Item> condition;
    private List<Item> expectedInventory;
    private Function<Item, Item> updateItem;

    @BeforeEach
    void setUp() {
        manager = new InventoryManager();
        character = new Character("Gandalf");
        stick = new Item("Stick", 1);
        stick2 = new Item("Stick", 1);
        sword = new Item("Sword", 1);
        consumer = (item) -> System.out.println(item.getName() + " was added to the inventory.");
        updateItem = (item) -> new Item(item.getName(), item.getValue() * 2);
        condition = (item) -> item.getName().equals("Stick");
        expectedInventory = new ArrayList<>();
    }

    @Test
    void testAddItem() {
        expectedInventory = Arrays.asList(stick, sword);
        manager.addItem(character, stick, consumer);
        manager.addItem(character, sword, consumer);
        assertEquals(expectedInventory, character.getInventory());
    }

    @Test
    void testRemoveItem() {
        expectedInventory = Arrays.asList(stick2, sword);
        fillInventory();
        manager.removeItem(character, condition);
        assertEquals(expectedInventory, character.getInventory());
    }

    @Test
    void testRemoveAllItemByCondition() {
        expectedInventory = Arrays.asList(sword);
        fillInventory();
        manager.removeAllItemsThatMatchCondition(character, condition);
        assertEquals(expectedInventory, character.getInventory());
    }

    @Test
    void testUpdateItem() {
        expectedInventory = Arrays.asList(new Item("Stick", 2), sword);
        fillInventory();
        manager.removeItem(character, condition);
        manager.updateItem(character, condition, updateItem);
        assertEquals(expectedInventory.get(0).getValue(), character.getInventory().get(0).getValue());
        assertEquals(expectedInventory.get(0).getName(), character.getInventory().get(0).getName());
    }

    private void fillInventory(){
        manager.addItem(character, stick, consumer);
        manager.addItem(character, stick2, consumer);
        manager.addItem(character, sword, consumer);
    }
}