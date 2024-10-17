package mod1sp12.lordOfTheRingRpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item minigun = new Item("M134 Minigun", 2000000);

        InventoryManager manager = new InventoryManager();

        // Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, minigun, item -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        // Удаляем предмет из инвентаря
        manager.removeItem(frodo, item -> item.getName().equals("The One Ring"));
        manager.removeItem(frodo, item -> item.getName().equals("Bow"));

        // Добавляем обратно предмет и обновляем его стоимость
        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> new Item(item.getName(), item.getValue() * 2));
        manager.updateItem(frodo, item -> item.getName().equals("Bow"), item -> new Item(item.getName(), item.getValue() * 2));
        manager.updateItem(frodo, item -> item.getName().equals("M134 Minigun"), item -> new Item(item.getName(), item.getValue() * 40));

        // Проверяем результат
        System.out.println("Итоговый список: ");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}