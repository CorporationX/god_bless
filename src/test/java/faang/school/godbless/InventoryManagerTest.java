package faang.school.godbless;

import faang.school.godbless.LordOfTheRingsRPG.Character;
import faang.school.godbless.LordOfTheRingsRPG.InventoryManager;
import faang.school.godbless.LordOfTheRingsRPG.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManagerTest {
    private Character character1;
    private Character character2;
    private InventoryManager manager;
    private Item sword1;
    private Item sword2;
    private Item shield1;
    private Item shield2;
    private Consumer<Item> successMessage;

    @BeforeEach
    public void setUp() {
        character1 = new Character();
        character2 = new Character();
        manager = new InventoryManager();

        shield1 = new Item("Shield", 50);
        sword1 = new Item("Sword", 100);

        shield2 = new Item("Shield", 70);
        sword2 = new Item("Sword", 150);

        successMessage = (item -> System.out.println(item.getName() + "Success added"));

        manager.addItem(character1, shield1, successMessage);
        manager.addItem(character1, sword1, successMessage);
        manager.addItem(character2, shield2, successMessage);
        manager.addItem(character2, sword2, successMessage);
    }

    @DisplayName("Add items to character inventory")
    @Test
    public void testAddItems() {
        assertTrue(character1.getInventory().contains(shield1));
        assertTrue(character1.getInventory().contains(sword1));
    }

    @DisplayName("remove items to character inventory")
    @Test
    public void testRemoveItems() {
        Predicate<Item> predicate = item -> item.getName().equals("Shield") && item.getValue() <= 50;
        manager.removeItem(character1, predicate);
        assertFalse(character1.getInventory().contains(shield1));


        manager.removeItem(character2, predicate);
        assertTrue(character2.getInventory().contains(shield2));
    }

    @DisplayName("remove items to character inventory")
    @Test
    public void testUpdateItems() {
        Predicate<Item> predicate = item -> item.getName().equals("Shield") && item.getValue() <= 100;
        Function<Item, Item> function = item -> new Item(item.getName().toUpperCase() + " *MegaItem", item.getValue() * 5);
        manager.updateItem(character1, predicate, function);
        assertNotEquals(shield1, character1.getInventory().get(0));
        assertEquals(250, character1.getInventory().get(0).getValue());
        assertEquals("SHIELD *MegaItem", character1.getInventory().get(0).getName());


        manager.updateItem(character2, predicate, function);
        assertNotEquals(shield2, character2.getInventory().get(0));
        assertEquals(350, character2.getInventory().get(0).getValue());
        assertEquals("SHIELD *MegaItem", character2.getInventory().get(0).getName());
    }

}
