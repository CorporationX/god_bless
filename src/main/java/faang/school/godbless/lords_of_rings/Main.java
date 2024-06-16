package faang.school.godbless.lords_of_rings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to the inventory"));
        inventoryManager.updateItem(frodo, (item -> item.name().equals("The One Ring")), item -> new Item(item.name(), item.value() * 2));
        inventoryManager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));
    }
}
