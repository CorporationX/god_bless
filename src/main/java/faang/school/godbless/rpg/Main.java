package faang.school.godbless.rpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

//// Добавляем предмет в инвентарь
        System.out.println("Hallo");
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

//// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> {
            System.out.println("The item is removed!");
            return item.getName().equals("The One Ring");
        });

//// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}
