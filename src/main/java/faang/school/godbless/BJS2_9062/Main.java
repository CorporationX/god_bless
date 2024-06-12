package faang.school.godbless.BJS2_9062;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        // Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item("111", item.getValue() * 2));

        manager.showAllList(frodo);

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
    }
}
