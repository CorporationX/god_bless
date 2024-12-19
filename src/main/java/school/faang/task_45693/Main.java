package school.faang.task_45693;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item phone = new Item("phone 4", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName()
                +
                " был добавлен в инвентарь."));

        manager.addItem(frodo, phone, (item) -> System.out.println(item.getName()
                +
                " был добавлен в инвентарь."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.updateItem(frodo, (item) -> item.getName().equals("phone 4"), (item) -> new Item("phone 15", 1500));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getName()));

    }

}
