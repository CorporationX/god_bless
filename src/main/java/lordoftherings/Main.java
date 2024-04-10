package lordoftherings;

public class Main {
    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item water = new Item("Water", 10);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, water, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println(frodo);

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println(frodo);

        manager.updater(frodo, (item) -> item.getName().equals("Water"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println(frodo);
    }
}
