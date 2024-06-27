package faang.school.godbless.sprint_2.functional_interface.task_23_lotr;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory."));

        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"), (item) -> new Item(item.name(), item.value() * 2));

        manager.showItem(frodo, System.out::println);

        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

    }
}
