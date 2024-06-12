package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        System.out.println(frodo.toString());

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        System.out.println(frodo.toString());

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        System.out.println(frodo.toString());
    }
}