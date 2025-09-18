package bjs2_90658;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет
        manager.addItem(frodo, ring,
                item -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        // Удаляем предмет
        manager.removeItem(frodo,
                item -> item.getName().contains("Ring"));

        // Добавляем обратно предмет
        manager.addItem(frodo, ring,
                item -> System.out.println(item.getName() + " снова добавлен."));

        // Увеличиваем цену предмета в 2 раза
        manager.updateItem(frodo,
                item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        // Проверка
        frodo.getInventory().forEach(item ->
                System.out.println(item.getName() + ": " + item.getValue()));
    }
}