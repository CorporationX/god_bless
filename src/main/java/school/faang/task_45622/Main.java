package school.faang.task_45622;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item palantir = new Item("Palantir", 1500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, palantir, (item) -> System.out.println(item.getName() + " добавлен в инвентарь."));

        try {
            manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.updateItem(frodo, (item) -> item.getName().equals("Palantir"),
                    (item) -> new Item(item.getName(), item.getValue() * 2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));

    }
}
