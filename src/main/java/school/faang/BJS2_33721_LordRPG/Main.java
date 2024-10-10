package school.faang.BJS2_33721_LordRPG;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item sword = new Item("Sword", 1000);
        Item ring = new Item("Ring", 10000000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, sword, 3, (item) -> System.out.println(item.getName() + " has been added to inventory."));
        manager.addItem(frodo, ring, 1, (item) -> System.out.println(item.getName() + " has been added to inventory."));

        System.out.println();
        frodo.getInventory().forEach((key, value) -> System.out.printf("%s, its count: %d\n", key, value));

        manager.updateItem(frodo, (item) -> item.getName().equals("Sword"), (item) -> new Item(item.getName(), item.getValue() * 5));
        manager.removeItem(frodo,2, (item) -> item.getName().equals("Sword"));

        System.out.println();
        frodo.getInventory().forEach((key, value) -> System.out.printf("%s, its count: %d\n", key, value));
    }
}
