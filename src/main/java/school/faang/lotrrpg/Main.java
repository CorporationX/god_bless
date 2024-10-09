package school.faang.lotrrpg;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager.addItem(
                frodo,
                ring,
                (item) -> System.out.println(item.getName() + " was added to inventory.")
        );
        InventoryManager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        InventoryManager.addItem(
                frodo,
                ring,
                (item) -> System.out.println(item.getName() + " was added again")
        );
        InventoryManager.updateItem(
                frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2)
        );

        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
