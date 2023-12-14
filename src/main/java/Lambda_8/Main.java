package Lambda_8;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        System.out.println();
        System.out.println("Frodo have:");
        for (Item item : frodo.getInventory()) {
            System.out.println("Item: " + item.getName() + " Value: " + item.getValue());
        }
        System.out.println();

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        System.out.println();
        System.out.println("Frodo have:");
        for (Item item : frodo.getInventory()) {
            System.out.println("Item: " + item.getName() + " Value: " + item.getValue());
        }
        System.out.println();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println();
        System.out.println("Frodo have:");
        for (Item item : frodo.getInventory()) {
            System.out.println("Item: " + item.getName() + " Value: " + item.getValue());
        }
        System.out.println();
    }
}
