package bjs2_70092;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.name() + " it was added to the inventory"));

        manager.removeItem(frodo, item -> item.name().contains("Ring"));

        manager.addItem(frodo, ring, item -> System.out.println(item.name() + " added to inventory again"));
        manager.updateItem(frodo, item -> item.name().equals("The One Ring"), item -> new Item(item.name(), item.value() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}
