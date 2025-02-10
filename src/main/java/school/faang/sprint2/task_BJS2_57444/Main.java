package school.faang.sprint2.task_BJS2_57444;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();


        // Удаляем предмет из инвентаря


        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));

        // Проверяем результат
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));


    }
}
