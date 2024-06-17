package faang.school.godbless.lambdas8;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item knife = new Item("The Knife", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));
        manager.addItem(frodo, knife, (item) -> System.out.println(item.name() + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.name().equals("The Knife"), (item) -> new Item(item.name(), item.value() * 2));
    }
}
