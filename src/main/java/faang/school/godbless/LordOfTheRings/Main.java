package faang.school.godbless.LordOfTheRings;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item skibidi = new Item("dop-dop", 2300);

        InventoryManager manager = new InventoryManager();


        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        manager.addItem(frodo, skibidi, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.inventory.forEach(System.out::println);
    }
}
