package school.faang.lord_of_the_rings;

public class Test {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The one Ring", 1337);
        Item mithrilWear = new Item("Mithril Wear", 100000);
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(ring, frodo, item -> System.out.println(item.getName() +
                " Was added in inventory"));

        inventoryManager.addItem(mithrilWear, frodo, item -> System.out.println(item.getName() +
                " was added in inventory"));

        inventoryManager.removeItem(frodo, item -> !item.getName().contains("Ring"));

        inventoryManager.updateItem(frodo, item -> item.getName().equalsIgnoreCase("the one ring"),
                item -> new Item(item.getName(), item.getValue() * 13));

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
