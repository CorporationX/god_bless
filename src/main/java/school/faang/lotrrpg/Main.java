package school.faang.lotrrpg;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getItemName() + " was added to the inventory"));
        manager.removeItem(frodo, item -> item.getItemName().equals("The One Ring"));
        System.out.println(frodo.getInventory());
        manager.addItem(frodo, ring, item -> System.out.println(item.getItemName() + " was added to the inventory"));
        System.out.println(frodo.getInventory());
        manager.updateItem(frodo, (item) -> item.getItemName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2));
        System.out.println(frodo.getInventory());
    }
}
