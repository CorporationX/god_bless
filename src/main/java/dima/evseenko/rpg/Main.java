package dima.evseenko.rpg;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("Dima");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character, new Item("Phone", 1000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        inventoryManager.addItem(character, new Item("Notebook", 2000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        System.out.println(character.getItems());

        inventoryManager.removeItem(character, (item -> item.getName().equals("Notebook")));
        System.out.println(character.getItems());

        inventoryManager.addItem(character, new Item("Notebook", 2000), (item -> System.out.println(item.getName() + " был добавлен в инвентарь " + character.getName())));
        inventoryManager.updateItem(character, (item -> item.getName().equals("Notebook")), (item -> new Item(item.getName(), item.getValue() / 2)));
        System.out.println(character.getItems());
    }
}
