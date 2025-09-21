package bjs2_90658;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет
        manager.addItem(frodo, ring,
                item -> System.out.println(item.name() + " был добавлен в инвентарь."));

        // Удаляем предмет
        manager.removeItem(frodo,
                item -> item.name().contains("Ring"));

        // Добавляем обратно предмет
        manager.addItem(frodo, ring,
                item -> System.out.println(item.name() + " снова добавлен."));

        // Увеличиваем цену предмета в 2 раза
        manager.updateItem(frodo,
                item -> item.name().equals("The One Ring"),
                item -> new Item(item.name(), item.value() * 2));

        // Проверка
        frodo.getInventory().forEach(item ->
                System.out.println(item.name() + ": " + item.value()));
    }
}