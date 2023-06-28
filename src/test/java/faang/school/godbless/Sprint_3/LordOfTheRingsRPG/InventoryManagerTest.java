package faang.school.godbless.Sprint_3.LordOfTheRingsRPG;

import faang.school.godbless.Sprint_3.Lambda.LordOfTheRingsRPG.Character;
import faang.school.godbless.Sprint_3.Lambda.LordOfTheRingsRPG.InventoryManager;
import faang.school.godbless.Sprint_3.Lambda.LordOfTheRingsRPG.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {
    Character frodo = new Character("Frodo S.");
    Item ring = new Item("Golden Ring", 1);

    InventoryManager manager = new InventoryManager();

    @Test
    public void addItemTest() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        assertEquals(frodo.getInventory().size(), 1);
    }

    @Test
    public void removeItemTest() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.removeItem(frodo, (item) -> item.getName().equals("Golden Ring"));

        assertEquals(frodo.getInventory().size(), 0);
    }

    @Test
    public void updateItemTest() {
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.updateItem(frodo, (item) -> item.getName().equals("Golden Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        assertEquals(frodo.getInventory().get(0).getValue(), 2);
    }

}