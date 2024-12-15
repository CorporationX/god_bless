package school.faang.task_45639;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item simpleRing = new Item("The Simple Ring", 5);

        InventoryManager manager = new InventoryManager();

        // Добавляем предметы в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, simpleRing, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        // Удаляем предметы из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));

        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        // Проверяем результат
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
