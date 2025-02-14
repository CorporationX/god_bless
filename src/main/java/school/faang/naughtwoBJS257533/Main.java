package school.faang.naughtwoBJS257533;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring,
                (item) -> System.out.println(item.getItemName() + " was added to inventory."));
        manager.removeItem(frodo, (item) -> item.getItemName().equals("The One Ring"));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getItemName() + " added again."));
        manager.updateItem(frodo,
                (item) -> item.getItemName().equals("The One Ring"),
                (item) -> new Item(item.getItemName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getItemName() + ": " + item.getValue()));
    }
}
