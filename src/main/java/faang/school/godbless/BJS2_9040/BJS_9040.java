package faang.school.godbless.BJS2_9040;

public class BJS_9040 {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item oldBoots = new Item("Old Boots", 1);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to " + frodo.getName() + " inventory"));
        inventoryManager.addItem(frodo, oldBoots, (item) -> System.out.println(item.getName() + " was added to " + frodo.getName() + " inventory"));
        inventoryManager.deleteItem(frodo, item -> item.getName().equals("Old Boots"));
        inventoryManager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> new Item(item.getName(), item.getValue() * 3));

        System.out.print("Your inventory is: ");
        frodo.getInventory().forEach(item -> System.out.print(item.getName() + " | " + item.getValue()));


    }
}