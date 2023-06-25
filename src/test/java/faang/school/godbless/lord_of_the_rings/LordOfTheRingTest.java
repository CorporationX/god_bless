package faang.school.godbless.lord_of_the_rings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LordOfTheRingTest {

    private Character frodo;
    private Item ring;
    private Item bow;
    private InventoryManager manager;

    private Consumer<Item> consumer;
    private Predicate<Item> predicate;
    private Function<Item, Item> function;

    @BeforeEach
    public void setUp() {
        frodo = new Character("Frodo");
        bow = new Item("Bow", 500);
        ring = new Item("The One Ring", 1000);
        List<Item> list = new ArrayList<>();
        list.add(bow);
        frodo.setInventory(list);
        manager = new InventoryManager();
        consumer = (item) -> System.out.println(item.getName() + " was added to inventory");
        predicate = (item) -> item.getName().equals("Bow");
        function = (item) -> new Item(item.getName(), item.getValue() * 2);
    }

    @Test
    public void testAddItem() {
        manager.addItem(frodo, ring, consumer);
        assertEquals(2, frodo.getInventory().size());
    }

    @Test
    public void testRemoveItem() {
        manager.removeItem(frodo, predicate);
        assertEquals(0, frodo.getInventory().size());
    }

    @Test
    public void testUpgradeItem() {
        manager.updateItem(frodo, predicate, function);
        assertEquals(1000, frodo.getInventory().get(0).getValue());
    }
}
