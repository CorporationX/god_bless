package lord_of_the_rings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManagerTest {
    private InventoryManager manager;
    private Character character;
    private Item ring;
    private Item sword;
    private Item shield;

    @BeforeEach
    public void setUp() {
        manager = new InventoryManager();
        character = new Character("Frodo", new ArrayList<>());
        ring = new Item("The One Ring", 1000);
        sword = new Item("Sting", 500);
        shield = new Item("Elven Shield", 800);
    }

    @Test
    public void testAddItem() {
        List<Item> inventory = character.inventory();
        Assertions.assertTrue(inventory.isEmpty());

        Consumer<Item> successConsumer = item -> {
            Assertions.assertEquals(ring, item);
            Assertions.assertTrue(inventory.contains(item));
        };

        manager.addItem(character, ring, successConsumer);

        Assertions.assertFalse(inventory.isEmpty());
        Assertions.assertEquals(1, inventory.size());
        Assertions.assertEquals(ring, inventory.get(0));
    }

    @Test
    public void testRemoveItem() {
        character.inventory().add(ring);
        character.inventory().add(sword);
        character.inventory().add(shield);

        Predicate<Item> condition = item -> item.name().equals("Sting");

        manager.removeItem(character, condition);

        List<Item> inventory = character.inventory();
        Assertions.assertEquals(2, inventory.size());
        Assertions.assertTrue(inventory.contains(ring));
        Assertions.assertTrue(inventory.contains(shield));
        Assertions.assertFalse(inventory.contains(sword));
    }

    @Test
    void testUpdateItem() {
        character.inventory().add(ring);
        character.inventory().add(sword);
        character.inventory().add(shield);

        Predicate<Item> condition = item -> item.name().equals("The One Ring");
        Function<Item, Item> updateFunction = item -> new Item(item.name(), item.value() * 2);

        manager.updateItem(character, condition, updateFunction);

        List<Item> inventory = character.inventory();
        Assertions.assertEquals(3, inventory.size());
        Assertions.assertEquals(new Item("The One Ring", 2000), inventory.get(0));
        Assertions.assertTrue(inventory.contains(sword));
        Assertions.assertTrue(inventory.contains(shield));
    }
}