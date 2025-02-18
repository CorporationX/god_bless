package lordoftherings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, ring,
                item -> System.out.printf("Item %s added to inventory.%n", item.getName()));
        inventoryManager.removeItem(frodo, item -> item.getName().equals("The One Ring"));
        inventoryManager.addItem(frodo, ring,
                item -> System.out.printf("Item %s added to inventory.%n", item.getName()));
        inventoryManager.updateItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));
        frodo.getInventory().forEach(item -> System.out.printf("Item %s has value %d.%n",
                item.getName(), item.getValue()));

    }
}
