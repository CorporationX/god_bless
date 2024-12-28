package school.faang.sprint_4.task_50734;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryTest {
    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void testCollectItemBaseCase() {
        Item item1 = new Item("Black", 20);
        Item item2 = new Item("King", 30);
        var expected = List.of(new Item("BlackKing", 50));

        inventory.collectItem(item1, item2).join();

        assertEquals(expected, inventory.getChest());
    }

    @Test
    void testCollectItemSameItems() {
        Item item = new Item("Black", 20);
        var expected = List.of(new Item("BlackBlack", 40));

        inventory.collectItem(item, item).join();

        assertEquals(expected, inventory.getChest());
    }

    @Test
    void testCollectItemWithNullItems() {
        assertThrows(
                NullPointerException.class,
                () -> inventory.collectItem(null, null)
        );
    }
}
