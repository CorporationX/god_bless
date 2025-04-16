package school.faang.lordoftheringsrpg;

public class Main {
    public static void main(String[] args) {
        // Создаем персонажа Frodo с не-null инвентарем (предполагаем, что конструктор и геттер создают нужный список)
        Character frodo = new Character("Frodo");
        InventoryManager manager = new InventoryManager();

        // Создаем предмет "The One Ring"
        Item ring = new Item("The One Ring", 1000);

        System.out.println("=== Тест: Добавление предмета в инвентарь ===");
        manager.addItem(frodo, ring, item ->
                System.out.printf("%s был добавлен в инвентарь.\n", item.getName()));

        // Выводим содержимое инвентаря после добавления
        System.out.println("\nInventory после добавления:");
        frodo.getInventory()
                .forEach(item -> System.out.printf("Предмет: %s, Цена: %d\n", item.getName(), item.getValue()));

        System.out.println("\n=== Тест: Удаление предмета (удаляем, если название содержит 'Ring') ===");
        manager.removeItem(frodo, item -> item.getName().contains("Ring"));
        System.out.printf("Предмет %s должен быть удалён из инвентаря.\n", ring.getName());

        // Выводим содержимое инвентаря после удаления
        System.out.println("\nInventory после удаления:");
        frodo.getInventory()
                .forEach(item -> System.out.printf("Предмет: %s, Цена: %d\n", item.getName(), item.getValue()));

        System.out.println("\n=== Тест: Обновление предмета (удваиваем стоимость) ===");
        // Добавляем обратно предмет для обновления
        manager.addItem(frodo, ring, item ->
                System.out.printf("%s был вновь добавлен для обновления.\n", item.getName()));

        // Обновляем предмет: если название совпадает, создаем новый предмет с удвоенной ценой
        manager.updateItem(frodo,
                item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        // Выводим содержимое инвентаря после обновления
        System.out.println("\nInventory после обновления:");
        frodo.getInventory()
                .forEach(item -> System.out.printf("Предмет: %s, Цена: %d\n", item.getName(), item.getValue()));
    }
}
