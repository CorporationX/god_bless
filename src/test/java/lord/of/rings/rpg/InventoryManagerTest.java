package lord.of.rings.rpg;

import faang.school.godbless.lord.of.rings.rpg.Character;
import faang.school.godbless.lord.of.rings.rpg.InventoryManager;
import faang.school.godbless.lord.of.rings.rpg.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InventoryManagerTest {

    @Test
    void testAddItem() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        Assertions.assertEquals(1, frodo.getInventory().size());
        Assertions.assertEquals(ring, frodo.getInventory().get(0));
    }

    @Test
    void testRemoveItem() {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item stone = new Item("Stone", 1);

        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, stone, item -> System.out.println(item.getName() + "was added to the inventory"));

        Assertions.assertEquals(2, frodo.getInventory().size());
        Assertions.assertTrue(frodo.getInventory().containsAll(List.of(ring, stone)));

        manager.removeItem(frodo, item -> item.getValue() == 1000);
        Assertions.assertEquals(1, frodo.getInventory().size());
        Assertions.assertEquals(stone, frodo.getInventory().get(0));
    }

    @Test
    void testUpdateItem() {
        Character frodo = new Character("Frodo");
        Item stone = new Item("Stone", 1);
        InventoryManager manager = new InventoryManager();
        manager.addItem(frodo, stone, item -> {
        });
        manager.updateItem(frodo, item -> item.getName().equals("Stone"), item -> new Item("Stone", 7));

        Assertions.assertEquals(1, frodo.getInventory().size());
        Assertions.assertEquals(7, frodo.getInventory().get(0).getValue());
    }

}
