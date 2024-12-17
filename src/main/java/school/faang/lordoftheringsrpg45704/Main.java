package school.faang.lordoftheringsrpg45704;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The one Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + " was add in inventory"));

        manager.removeItem(frodo, (item) -> item.getName().equals("The one Ring"));

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " again add"));
        manager.updateItem(frodo, (item) -> item.getName().equals("The one Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> System.out.println(item.getName()
                + ": " + item.getValue()));
    }
}
