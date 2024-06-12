package BJS2_9039;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item shield = new Item("Shield", 150);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));
        manager.addItem(frodo, shield, (item) -> System.out.println(item.name() + " was added to the inventory."));

        System.out.println(frodo.getItems());
        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.name().equals("Shield"), (item) -> new Item(item.name(), item.value() * 2));
        System.out.println(frodo.getItems());
    }
}