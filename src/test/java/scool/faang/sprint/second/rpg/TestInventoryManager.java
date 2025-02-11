package scool.faang.sprint.second.rpg;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import school.faang.sprint.second.rpg.Character;
import school.faang.sprint.second.rpg.InventoryManager;
import school.faang.sprint.second.rpg.Item;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestInventoryManager {
    private InventoryManager inventoryManager;
    private Item ring;
    private Character frodo;
    private Consumer<Item> createConsumer;
    private Predicate<Item> updateAndRemovePredicate;
    private Consumer<Item> updateConsumer;


    @Before
    public void setUp() {
        inventoryManager = Mockito.spy(InventoryManager.class);
        ring = new Item("The One Ring", 1000);
        frodo = new Character("Frodo");
        createConsumer = (item) -> System.out.println(item.getName());
        updateAndRemovePredicate = (item) -> item.getName().equals("The One Ring");
        updateConsumer = (item -> item.setValue(item.getValue() * 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenCreateCharacter() {
        new Character("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenCreateItem() {
        new Item("", 0);
    }

    @Test
    public void testAddItem() {
        inventoryManager.addItem(frodo, ring, createConsumer);

        Mockito.verify(inventoryManager, Mockito.times(1))
                .addItem(frodo, ring, createConsumer);
    }

    @Test
    public void testRemoveItem() {
        inventoryManager.addItem(frodo, ring, createConsumer);
        inventoryManager.removeItem(frodo, updateAndRemovePredicate);

        Mockito.verify(inventoryManager, Mockito.times(1))
                .removeItem(frodo, updateAndRemovePredicate);
    }

    @Test
    public void testUpdateItem() {
        inventoryManager.addItem(frodo, ring, createConsumer);
        inventoryManager.updateItem(frodo, updateAndRemovePredicate, updateConsumer);

        Mockito.verify(inventoryManager, Mockito.times(1))
                .updateItem(frodo, updateAndRemovePredicate, updateConsumer);
    }
}
