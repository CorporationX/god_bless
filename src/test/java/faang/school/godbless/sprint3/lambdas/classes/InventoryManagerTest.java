package faang.school.godbless.sprint3.lambdas.classes;

import faang.school.godbless.sprint3.lordsOfTheRings.classes.Character;
import faang.school.godbless.sprint3.lordsOfTheRings.classes.InventoryManager;
import faang.school.godbless.sprint3.lordsOfTheRings.classes.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryManagerTest {

    private static final Consumer<Item> consumer = item -> System.out.println(item.getName() + " was added tp the inventory");
    private static final Predicate<Item> predicate = item -> item.getName().equals("The One Ring");
    private static final Function<Item, Item> function = item -> new Item(item.getName(), item.getValue() + 2);
    private static final Item item = new Item("The One Ring", 2);

    private static Character character;
    private static InventoryManager inventoryManager;

    @BeforeAll
    static void setUp() {
        character = new Character("Frodo");
        inventoryManager = new InventoryManager();
    }

    @Test
    @DisplayName("Предмет добавляется")
    void addItem_test() {
        inventoryManager.addItem(character, item, consumer);
        assertTrue(character.getInventory().contains(item));
    }

    @Test
    @DisplayName("Предмет удаляется")
    void removeItem_test() {
        inventoryManager.addItem(character, item, consumer);
        assertTrue(character.getInventory().contains(item));

        inventoryManager.removeItem(character, predicate);
        assertFalse(character.getInventory().contains(item));
    }

    @Test
    @DisplayName("Предмет изменяется")
    void updateItem_test() {
        inventoryManager.addItem(character, item, consumer);
        assertTrue(character.getInventory().contains(item));

        inventoryManager.updateItem(character, predicate, function);
        assertEquals(4, character.getInventory().get(0).getValue());
    }

}