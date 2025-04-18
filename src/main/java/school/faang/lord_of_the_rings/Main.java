package school.faang.lord_of_the_rings;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("Кольцо", 1000);
        Item sword = new Item("Меч", 500);
        Item shield = new Item("Щит", 300);

        Character frodo = new Character("Frodo");
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, new Item("One Ring", 1000),
                item -> System.out.printf("Added: %s%n", item.name()));
        manager.addItem(frodo, new Item("Sting Sword", 500),
                item -> System.out.printf("Added: %s%n", item.name()));
        System.out.printf("Inventory before removal: %s%n", frodo.getInventory());

        manager.removeItem(frodo, item -> item.name().contains("Ring"));
        System.out.printf("Inventory after removal: %s%n", frodo.getInventory());

        manager.updateItem(frodo,
                item -> item.name().contains("Ring"),
                item -> new Item(item.name(), item.value() * 2));
        System.out.printf("Inventory after update: %s%n", frodo.getInventory());
    }
}