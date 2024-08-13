package faang.school.godbless.BJS2_21235;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item stick = new Item("The One Stick", 100);
        Item hat = new Item("The One Hat", 300);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, stick, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, hat, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        System.out.println("Current inventory:");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Stick"));
        System.out.println("Inventory after remove item");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println("Inventory after update item");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
