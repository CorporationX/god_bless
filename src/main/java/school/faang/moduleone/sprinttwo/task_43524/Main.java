package school.faang.moduleone.sprinttwo.task_43524;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        boolean isItemRemoved = manager.removeItem(frodo, ring, (item) -> item.getName().equals("The One Ring"));
        if (isItemRemoved) {
            System.out.println("Удаление The One Ring прошло успешно");
        } else {
            System.out.println("Удаление The One Ring не состоялось");
        }

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
