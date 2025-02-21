package lord_of_the_rings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");

        Item ring = new Item("The One Ring", 1000);
        Item sword = new Item("Sword", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println("Item added: " + item));
        manager.addItem(frodo, sword, item -> System.out.println("Item added: " + item));

        manager.removeItem(frodo, item -> "The One Ring".equals(item.getName()));

        manager.updateItem(frodo, item -> "Sword".equals(item.getName()), item -> {
            item.setValue(item.getValue() * 2);
            return item;
        });

        System.out.println("Inventory after changes:");
        frodo.getInventory().forEach(System.out::println);
    }
}
