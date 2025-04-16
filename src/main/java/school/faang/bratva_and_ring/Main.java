package school.faang.bratva_and_ring;

public class Main {
    public static void main(String[] args) {
        Item ring = new Item("ring", 500);
        Item sword = new Item("sword", 600);

        Character frodo = new Character("Frodo");

        InventoryManager manager = new InventoryManager();

        manager.addItem(ring, frodo, item -> System.out.println("Предмет добален"));
        manager.addItem(sword, frodo, item -> System.out.println("Предмет добален"));

        manager.removeItem(frodo, item -> item.name().equals("ring"));

        frodo.getInventory().forEach(System.out::println);
        manager.update(frodo, item -> item.name().equals("sword"),
                item -> new Item(item.name(), item.value() + 100));

        frodo.getInventory().forEach(System.out::println);
    }
}
