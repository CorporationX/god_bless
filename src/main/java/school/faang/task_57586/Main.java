package school.faang.task_57586;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item sword = new Item("The Sword", 500);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(
                frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2)
        );

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
