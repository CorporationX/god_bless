package faang.school.godbless.sprint2.lordOfRings;

public class Main {

    public static void main(String[] args) {
        try {
            Character frodo = new Character("Frodo");
            Item ring = new Item("The One Ring", 1000);

            InventoryManager manager = new InventoryManager();

            manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

            manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

            manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

            manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
        }
    }
}
