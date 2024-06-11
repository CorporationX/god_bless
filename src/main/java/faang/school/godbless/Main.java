package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item ball = new Item("The Magic Ball", 700);
        Item sphere = new Item("The Magic Sphere", 3000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, ball, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, sphere, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        frodo.printInventory();

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        frodo.printInventory();

        manager.updateItem(frodo, (item) -> item.getName().equals("The Magic Sphere"), (item) -> new Item(item.getName(), item.getValue() * 2));
        frodo.printInventory();
    }
}
