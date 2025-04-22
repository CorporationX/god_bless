package school.faang.bjs2_70126;

/**
 * Задача "Lord of the Rings RPG"
 */
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(ring, frodo, item -> System.out.println(item.name() + " был добавлен в инвентарь."));

        manager.removeItem(frodo, item -> item.name().contains("Ring"));

        manager.addItem(ring, frodo, item -> System.out.println(item.name() + " снова добавлен."));
        manager.updateItem(frodo,
                item -> item.name().equals("The One Ring"),
                item -> new Item(item.name(), item.value() * 2)
        );

        frodo.getInventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}
