package school.faang.bjs2_80306;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class InventoryManagerTest {
    private static final int COST_INCREASE = 125;

    private Consumer<Item> handler;
    private Predicate<Item> predicate;
    private Function<Item, Item> updaterItem;
    private final InventoryManager inventoryManager = new InventoryManager();
    private final List<Item> geraltInventory = new ArrayList<>(List.of(new Item("Sword", 1000),
                                                                 new Item("Potion", 25)));
    private final Character gerald = new Character("Geralt of Rivia", geraltInventory);

    @Test
    void shouldAddItem() {
        handler = item -> log.info("Предмет {} добавлен в интвентарь", item.getName());
        Item oil = new Item("Oil", 30);

        inventoryManager.addItem(gerald, oil, handler);

        assertTrue(geraltInventory.contains(oil));
    }

    @Test
    void shouldRemoveItem() {
        predicate = item -> item.getName().equals("Sword");

        inventoryManager.removeItem(gerald, predicate);

        boolean actual = geraltInventory.stream().anyMatch(predicate);
        assertFalse(actual);
    }

    @Test
    void shouldUpdateItem() {
        predicate = item -> item.getName().equals("Sword");
        updaterItem = item -> new Item(item.getName(), item.getValue() + COST_INCREASE);
        List<Item> expected = new ArrayList<>(geraltInventory);

        inventoryManager.updateItem(gerald, predicate, updaterItem);

        List<Item> actual = gerald.inventory();
        assertNotEquals(actual, expected);
    }

    @Test
    void shouldNotUpdateItem() {
        predicate = item -> item.getName().equals("Oil");
        updaterItem = item -> new Item(item.getName(), item.getValue() + COST_INCREASE);
        List<Item> expected = new ArrayList<>(geraltInventory);

        inventoryManager.updateItem(gerald, predicate, updaterItem);

        List<Item> actual = gerald.inventory();
        assertEquals(actual, expected);
    }
}