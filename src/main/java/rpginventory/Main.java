package rpginventory;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("Character 1");
        Item ring = new Item("some item", 1000);
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(character, ring, item -> System.out.println("Был добавлен: " + item.getName()));
        System.out.println(character.getInventory());

        inventoryManager.removeItem(character, item -> item.getName().equals("some item"));
        System.out.println(character.getInventory());

        inventoryManager.addItem(character, ring, item -> System.out.println("Снова добавили: " + item.getName()));
        inventoryManager.updateItem(character, item -> item.getName().equals("some item"),
                item -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(character.getInventory());
    }
}
