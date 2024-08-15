package faang.school.godbless.RPG;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000, false);
        Item cloak = new Item("Shabby cloak", 137, true);
        Item lembasBread = new Item("Lembas Bread", 15, true, true);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.getName() + "was successfully added to the inventory"));
        manager.addItem(frodo, cloak, item -> System.out.println(item.getName() + "was successfully added to the inventory"));
        manager.addItem(frodo, lembasBread, item -> System.out.println(item.getName() + "was successfully added to the inventory"));

        manager.removeItem(frodo, cloak, item -> item.isRemovable());

        manager.updateItem(frodo, lembasBread, (item) -> item.isPerishable(), (item) -> {
            System.out.println(item.getName() + " spoiled");
            return new Item(item.getName(), item.getValue() / 10, item.isRemovable(), true);
        });

        for (Item item : frodo.getInventory()) {
            System.out.println(item);
        }
    }
}
