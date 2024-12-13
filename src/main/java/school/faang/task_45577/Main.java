package school.faang.task_45577;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.name()
                + " успешно был добавлен в иневтарь персонажа"));

        manager.removeItem(frodo, item -> item.name().equals("The One Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " снова добавлен."));

        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));

        // Проверяем результат
        frodo.getInventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}
