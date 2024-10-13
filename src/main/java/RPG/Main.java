package RPG;

public class Main {
    public static void main(String[] args) {
        Item sword = new Item("sword", 1000);
        Item spear = new Item("spear", 1500);
        Character orlandoBloom = new Character();
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(sword, orlandoBloom,
                (item) -> System.out.println("The " + item.getName() + " has been added to the inventory"));
        inventoryManager.addItem(spear, orlandoBloom,
                (item) -> System.out.println("The " + item.getName() + " has been added to the inventory"));

        inventoryManager.removeItem(orlandoBloom,
                (item) -> item.getName().equals("sword"));

        inventoryManager.updateItem(orlandoBloom,
                (item) -> item.getName().equals("spear"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        orlandoBloom.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
