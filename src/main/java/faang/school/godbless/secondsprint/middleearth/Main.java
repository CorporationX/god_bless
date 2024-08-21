package faang.school.godbless.secondsprint.middleearth;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        // Печатаем инвентарь Фродо
        System.out.println("Frodo's inventory: " + frodo.getInventory());

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        // Печатаем инвентарь Фродо после удаления
        System.out.println("Frodo's inventory after removal: " + frodo.getInventory());

        // Добавляем предмет снова для демонстрации обновления
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory again."));

        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        // Печатаем инвентарь Фродо после обновления
        System.out.println("Frodo's inventory after update: " + frodo.getInventory());
    }
}
