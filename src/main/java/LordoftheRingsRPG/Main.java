package LordoftheRingsRPG;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("Ring", 1000);
        Item sword = new Item("Sword", 2300);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, ring, item -> System.out.println(item.getName() + " was added to the inventory."));
        inventoryManager.addItem(frodo, sword, item -> System.out.println(item.getName() + " was added to the inventory."));

        inventoryManager.removeItem(frodo, item -> item.getName().equals("Sword"));

        inventoryManager.updateItem(frodo, item -> item.getName().equals("Ring"), item -> new Item(item.getName(), item.getValue() * 2));
        frodo.getInventory().forEach(System.out::println);
    }
}
