package faang.school.godbless.task.lambda.lord.of.the.rings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Фродо");
        Item ring = new Item("Кольцо", 1000);
        Item elfSword = new Item("Мечь эльфов", 1000);
        Item apple = new Item("Яблоко", 1000);

        InventoryManager manager = new InventoryManager();

        System.out.println("Инвентарь %s: ".formatted(frodo.getName()) + frodo.getInventory());

        // Добавляем предметы в инвентарь
        System.out.println("\nДобавление %s в инвентарь".formatted(ring.getName()));
        manager.addItem(frodo, ring,
                (item) -> System.out.println(item.getName() + " добавлен в инвентарь."));
        System.out.println("\nДобавление %s в инвентарь".formatted(elfSword.getName()));
        manager.addItem(frodo, elfSword,
                (item) -> System.out.println(item.getName() + " добавлен в инвентарь."));
        System.out.println("\nДобавление %s в инвентарь".formatted(apple.getName()));
        manager.addItem(frodo, apple,
                (item) -> System.out.println(item.getName() + " добавлен в инвентарь."));
        System.out.println("Инвентарь %s: ".formatted(frodo.getName()) + frodo.getInventory());

        // Удаляем предмет из инвентаря
        System.out.println("\nУдаление %s из инвентаря".formatted(apple.getName()));
        manager.removeItem(frodo, (item) -> item.getName().equals(apple.getName()));
        System.out.println("Инвентарь %s: ".formatted(frodo.getName()) + frodo.getInventory());

        // Обновляем предмет в инвентаре
        System.out.println("\nОбновление %s в инвентаре".formatted(ring.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals(ring.getName()),
                (item) -> new Item(item.getName(), item.getValue() * 2));
        System.out.println("Инвентарь %s: ".formatted(frodo.getName()) + frodo.getInventory());
    }
}
