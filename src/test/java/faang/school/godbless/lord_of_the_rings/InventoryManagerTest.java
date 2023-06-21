package faang.school.godbless.lord_of_the_rings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    private Character hobbit;
    private Item ring, spear, sword;

    @BeforeEach
    void setUp() {
        ring = new Item("The One Ring", 1000);
        spear = new Item("Aeglos", 1500);
        sword = new Item("Narsil", 2000);
        hobbit = new Character("Frodo", new ArrayList<>(Arrays.asList(ring, spear)));
    }

    @Test
    void addItem() {
        InventoryManager.addItem(hobbit, sword,
                (item) -> System.out.println(item.getName() + " was added to the inventory."));
        assertTrue(hobbit.getInventory().contains(sword));
        assertEquals(3, hobbit.getInventory().size());
    }

    @Test
    void updateItem() {
        InventoryManager.updateItem(hobbit,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        Item updatedRing = hobbit.getInventory().stream()
                .filter(item -> item.getName().equals("The One Ring"))
                .findFirst()
                .orElse(null);

        assertEquals(2000, updatedRing.getValue());
        assertEquals(2, hobbit.getInventory().size());
    }

    @Test
    void removeItem() {
        InventoryManager.removeItem(hobbit, item -> item.getName().equals("The One Ring"));

        assertFalse(hobbit.getInventory().contains(ring));
        assertEquals(1, hobbit.getInventory().size());
    }
}