package school.faang.sprint_2.task_45526;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager.addItem(frodo, ring,
                (item) -> System.out.println(item.name() + " был добавлен в инвентарь."));

        InventoryManager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

        InventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " снова добавлен."));
        InventoryManager.updateItem(frodo,
                (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}
