package faang.school.godbless.bjs2_21238;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class InventoryManagerTest {
    private InventoryManager manager;
    private Character character;

    @BeforeEach
    void setup() {
        manager = new InventoryManager();
        character = new Character();
    }

    @Test
    void testAddItem() {
        var item = new Item("Item", 1);
        int valueToCheckConsumer = 666;
        manager.addItem(character, item, i -> i.setValue(valueToCheckConsumer));
        List<Item> foundItem = character.getInventory();
        assertEquals(1, foundItem.size());
        assertEquals(valueToCheckConsumer, foundItem.get(0).getValue());
    }

    @Test
    void testRemoveItem() {
        var item1 = new Item("First Item", 1);
        var item2 = new Item("Item", 1);
        var item3 = new Item("Item", 1);
        var item4 = new Item("Last Item", 1);
        manager.addItem(character, item1, i -> System.out.println());
        manager.addItem(character, item2, i -> System.out.println());
        manager.addItem(character, item3, i -> System.out.println());
        manager.addItem(character, item4, i -> System.out.println());
        List<Item> itemsBeforeRemoving = character.getInventory();
        assertEquals(4, itemsBeforeRemoving.size());
        manager.removeItem(character, i -> i.getName().startsWith("I"));
        List<Item> itemsAfterRemoving = character.getInventory();
        assertEquals(2, itemsAfterRemoving.size());
        assertFalse(itemsAfterRemoving.contains(item2));
        assertFalse(itemsAfterRemoving.contains(item3));
    }

    @Test
    void testUpdateItem1() {
        var item1 = new Item("First Item", 1);
        var item2 = new Item("Item", 1);
        var item3 = new Item("Item", 1);
        var item4 = new Item("Last Item", 1);
        manager.addItem(character, item1, i -> System.out.println());
        manager.addItem(character, item2, i -> System.out.println());
        manager.addItem(character, item3, i -> System.out.println());
        manager.addItem(character, item4, i -> System.out.println());
        List<Item> itemsBeforeUpdating = character.getInventory();
        assertEquals(4, itemsBeforeUpdating.size());
        manager.updateItem1(character, i -> i.getName().startsWith("I"), i -> new Item(i.getName(), i.getValue() + 1));
        List<Item> itemsAfterUpdating = character.getInventory();
        assertEquals(4, itemsAfterUpdating.size());
        assertEquals(1, itemsAfterUpdating.get(0).getValue());
        assertEquals(1, itemsAfterUpdating.get(1).getValue());
        assertEquals(2, itemsAfterUpdating.get(2).getValue());
        assertEquals(2, itemsAfterUpdating.get(3).getValue());
    }

    @Test
    void testUpdateItem2() {
        var item1 = new Item("First Item", 1);
        var item2 = new Item("Item", 1);
        var item3 = new Item("Item", 1);
        var item4 = new Item("Last Item", 1);
        manager.addItem(character, item1, i -> System.out.println());
        manager.addItem(character, item2, i -> System.out.println());
        manager.addItem(character, item3, i -> System.out.println());
        manager.addItem(character, item4, i -> System.out.println());
        List<Item> itemsBeforeUpdating = character.getInventory();
        assertEquals(4, itemsBeforeUpdating.size());
        manager.updateItem2(character, i -> i.getName().startsWith("I"), i -> new Item(i.getName(), i.getValue() + 1));
        List<Item> itemsAfterUpdating = character.getInventory();
        assertEquals(4, itemsAfterUpdating.size());
        assertEquals(1, itemsAfterUpdating.get(0).getValue());
        assertEquals(2, itemsAfterUpdating.get(1).getValue());
        assertEquals(2, itemsAfterUpdating.get(2).getValue());
        assertEquals(1, itemsAfterUpdating.get(3).getValue());
    }
}