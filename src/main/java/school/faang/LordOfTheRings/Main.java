package school.faang.LordOfTheRings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("FRODO");
        Item ring = new Item("The One Ring", 55555);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(frodo, ring, (item)
                -> System.out.println(item.getName() + " was added to your inventory"));

        System.out.println("-------------");
        inventoryManager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        inventoryManager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " added again"));

        System.out.println("-------------");

        inventoryManager.updateItem(frodo, (item)
                -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + " " + item.getValue()));
    }
}
