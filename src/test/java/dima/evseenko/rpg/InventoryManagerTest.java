package dima.evseenko.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InventoryManagerTest {

    @Test
    void addItem() {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, new Item("Phone", 1000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));

        assertEquals(new Item("Phone", 1000), character.getItems().get(0));
    }

    @Test
    void addNullItem() {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, null, (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));

        assertEquals(0, character.getItems().size());
    }

    @Test
    void deleteItem() {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, new Item("Phone", 1000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        inventoryManager.removeItem(character, (item -> item.getName().equals("Phone")));

        assertEquals(0, character.getItems().size());
    }

    @Test
    void deleteNotExistsItem() {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, new Item("Phone", 1000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        inventoryManager.removeItem(character, (item -> item.getName().equals("Notebook")));

        assertEquals(1, character.getItems().size());
    }

    @Test
    void updateItem() {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, new Item("Phone", 1000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        inventoryManager.updateItem(character, (item -> item.getName().equals("Phone")), (item -> new Item(item.getName(), item.getValue() / 2)));

        assertEquals(500, character.getItems().get(0).getValue());
    }

    @Test
    void updateNotExistsItem() {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, new Item("Phone", 1000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        inventoryManager.updateItem(character, (item -> item.getName().equals("Notebook")), (item -> new Item(item.getName(), item.getValue() / 2)));

        assertEquals(1000, character.getItems().get(0).getValue());
    }
}