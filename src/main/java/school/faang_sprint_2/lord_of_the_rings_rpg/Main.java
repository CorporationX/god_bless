package school.faang_sprint_2.lord_of_the_rings_rpg;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(ring, frodo, item -> System.out.println(item.getName() + " was added to the inventory"));
        manager.removeItem(frodo, item -> item.getName().equals("The One Ring"));

        manager.addItem(ring, frodo, item -> System.out.println(item.getName() + " again added to the inventory"));
        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"), item -> new Item(item.getName(), item.getPrice() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getPrice()));
    }
}
