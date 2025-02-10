package school.faang.sprint2.task_BJS2_57444;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверка класса InventoryManager")
class InventoryManagerTest {
    private final InventoryManager manager = new InventoryManager();
    private final Character frodo = new Character("Frodo");
    private final int defaultCost = 1000;
    private final Item ring = new Item("The One Ring", defaultCost);

    @BeforeEach
    public void setUp() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
    }

    @Test
    @DisplayName("Проверка добавления предмета")
    public void addItem_rightParam() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        assertTrue(frodo.getInventory().contains(ring));
    }

    @Test
    @DisplayName("Проверка удаления предмета")
    public void removeItem() {
        assertTrue(frodo.getInventory().contains(ring));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        assertFalse(frodo.getInventory().contains(ring));
    }

    @Test
    @DisplayName("Проверка изменения предмета")
    public void updateItem() {
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2));
        assertTrue(ring.getValue() == defaultCost * 2);
    }
}