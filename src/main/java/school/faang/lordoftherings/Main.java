package school.faang.lordoftherings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item ring2 = new Item("The Second Ring", 2000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " item has been added to the inventory"));
        manager.addItem(frodo, ring2, (item) -> System.out.println(item.getName() + " item has been added to the inventory"));
        System.out.println("\nINVENTORY:");
        frodo.displayInventory();

        // Удаляем предмет из инвентаря
        System.out.println("\nINVENTORY AFTER DELETION:");
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        frodo.displayInventory();

        // Добавляем обратно предмет и обновляем его стоимость
        System.out.println("\nNEW ITEM ADDED:");
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " has been added again"));

        System.out.println("\nINVENTORY BEFORE UPDATE:");
        frodo.displayInventory();

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 50));

        // Проверяем результат
        System.out.println("\nINVENTORY AFTER UPDATE:");
        frodo.displayInventory();
    }
}
