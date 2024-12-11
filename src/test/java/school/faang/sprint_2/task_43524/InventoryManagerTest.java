package school.faang.sprint_2.task_43524;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    Character frodo;
    InventoryManager manager;
    Item ring;
    Consumer<Item> printMessage;
    Predicate<Item> filter;

    @BeforeEach
    void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        manager = new InventoryManager();
        printMessage = (item) -> System.out.println(item.getName() + " был добавлен в инвентарь.");
        filter = item -> item.getName().equals("The One Ring");
    }

    @Test
    public void givenInventory_whenAddNewItem_thenReturnInventoryWithNewItem() {
        manager.addItem(frodo, ring, printMessage);
        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    public void givenInventory_whenRemoveItem_thenReturnInventoryWithoutItem() {
        manager.addItem(frodo, ring, printMessage);
        manager.removeItem(frodo, filter);
        assertEquals(0, frodo.getInventory().size());
    }

    @Test
    public void givenInventory_whenUpdateItems_thenReturnInventoryWithUpdateItems() {
        Item sword = new Item("Sword", 500);
        manager.addItem(frodo, ring, printMessage);
        manager.addItem(frodo, sword, printMessage);
        Function<Item, Item> updater = (item) -> new Item(item.getName(), item.getValue() * 2);
        manager.updateItem(frodo, filter, updater);
        assertAll(
                () -> assertEquals(2000, frodo.getInventory().get(0).getValue()),
                () -> assertEquals(500, frodo.getInventory().get(1).getValue())
        );
    }
}