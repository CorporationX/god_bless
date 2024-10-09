package school.faang.sprint_2.bjs2_33712;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryManagerTest {
    @Test
    void testAddRemoveAndUpdateItem() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item elvenChainmail = new Item("Бронежилетка кожи с жопы дракона", 300);
        Item bread = new Item("Хлебушек", 20);
        Set<Item> frodoBackpack = frodo.getInventory();
        int ringValue = ring.getValue();

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен!"));
        manager.addItem(frodo, elvenChainmail, (item) -> System.out.println(item.getName() + " была добавлен!"));
        manager.addItem(frodo, bread, (item) -> System.out.println(item.getName() + " был добавлен!"));

        assertTrue(frodoBackpack.contains(ring));
        assertTrue(frodoBackpack.contains(elvenChainmail));
        assertTrue(frodoBackpack.contains(bread));

        manager.removeItem(frodo, (item) -> item.getName().equalsIgnoreCase("хЛеБушЕк"));

        assertTrue(frodoBackpack.contains(ring));
        assertTrue(frodoBackpack.contains(elvenChainmail));
        assertFalse(frodoBackpack.contains(bread));

        manager.updateItemValue(frodo, (item) -> item.getName().equalsIgnoreCase("the one ring"),
                (item) -> item.setValue(item.getValue() * 2));

        assertEquals((ringValue * 2), ring.getValue());
    }
}