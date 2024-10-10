package school.faang.lord.of.the.rings;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryManagerTest {
    private Character frodo;
    private Item ring;

    private Consumer<Item> addItemAction1;
    private Consumer<Item> addItemAction2;
    private Predicate<Item> filter;
    private Function<Item, Item> updateAction;

    @BeforeEach
    public void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);

        addItemAction1 = item -> System.out.println(item.getName() + " был добавлен в инвентарь.");
        addItemAction2 = item -> System.out.println(item.getName() + " снова добавлен.");
        filter = item -> item.getName().equals("The One Ring");
        updateAction = item -> new Item(item.getName(), item.getValue() * 2);
    }

    @Test
    void addItemTest() {
        int sizeBefore = frodo.getInventory().size();

        InventoryManager.addItem(frodo, ring, addItemAction1);

        assertEquals(sizeBefore + 1, frodo.getInventory().size());
    }

    @Test
    void deleteItemTest() {
        InventoryManager.addItem(frodo, ring, addItemAction1);
        int sizeBefore = frodo.getInventory().size();

        InventoryManager.removeItem(frodo, filter);

        assertEquals(sizeBefore - 1, frodo.getInventory().size());
    }

    @Test
    void updateItemValueTest() {
        InventoryManager.addItem(frodo, ring, addItemAction2);
        int valueBefore = frodo.getInventory().get(0).getValue();

        InventoryManager.updateItem(frodo, filter, updateAction);

        assertEquals(valueBefore * 2, frodo.getInventory().get(0).getValue());
    }
}
