package faang.school.godbless.BJS2_21251;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryManagerTest {

    Character character = new Character();
    InventoryManager inventoryManager = new InventoryManager();


    @BeforeEach
    void init() {
        Item sword = new Item("Sword", 100);
        Item ring = new Item("Ring", 500);
        Item helmet = new Item("Helmet", 1000);
        Item boots = new Item("Boots", 2000);

        character.getInventory().add(sword);
        character.getInventory().add(ring);
        character.getInventory().add(helmet);
        character.getInventory().add(boots);
    }

    @Test
    void addItemTest() {
        int size = character.getInventory().size();
        assertEquals(size, 4);

        Item ring = new Item("The One Ring", 1000);

        inventoryManager.addItem(character, ring, item -> System.out.println(item.getName() + " was added to the inventory."));

        assertEquals(size + 1, character.getInventory().size());
    }

    @Test
    void removeItemTest() {
        assertEquals(4, character.getInventory().size());
        inventoryManager.removeItem(character, item -> item.getValue() > 500);
        assertEquals(2, character.getInventory().size());
    }

    @Test
    void updateItemTest() {
        Item ring = character.getInventory().get(1);
        assertEquals(500, ring.getValue());

        inventoryManager.updateItem(character, item -> item.getName().equals("Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        ring = character.getInventory().get(1);

        assertEquals(1000, ring.getValue());
    }
}