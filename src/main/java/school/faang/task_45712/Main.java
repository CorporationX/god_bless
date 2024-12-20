package school.faang.task_45712;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        System.out.println("Вывод инвенторя:");
        for (Item item : frodo.getInventory()) {
            System.out.println(item.getName() + " " + item.getValue());
        }
        System.out.println("Конец вывода инвенторя:");

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println("Вывод инвенторя:");
        for (Item item : frodo.getInventory()) {
            System.out.println(item.getName() + " " + item.getValue());
        }
        System.out.println("Конец вывода инвенторя:");

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
