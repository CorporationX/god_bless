package school.faang.bjs2_90653;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName()
                + " has been added in inventory."));

        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " add again."));
        manager.updateItem(frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }

}