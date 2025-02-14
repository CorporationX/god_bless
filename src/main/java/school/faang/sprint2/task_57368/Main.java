package school.faang.sprint2.task_57368;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() +
                " was added to the inventory."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " added again."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) ->
                new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
