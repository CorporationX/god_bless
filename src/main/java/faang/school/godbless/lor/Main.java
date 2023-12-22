package faang.school.godbless.lor;

public class Main {
    public static void main (String[] args) {
        Character bilbo = new Character("Bilbo");

        Item ring = new Item("ring", 1);
        Item circlet = new Item("circlet", 1);

        InventoryManager inventory = new InventoryManager();


        inventory.addItem(bilbo, ring, (item) -> System.out.println("Item added = " + item));
        inventory.addItem(bilbo, ring, (item) -> System.out.println("Item added = " + item));
        inventory.addItem(bilbo, ring, (item) -> System.out.println("Item added = " + item));
        inventory.addItem(bilbo, ring, (item) -> System.out.println("Item added = " + item));
        inventory.addItem(bilbo, circlet, (item) -> System.out.println("Item added = " + item)); // Output: circlet 1
        inventory.addItem(bilbo, circlet, (item) -> System.out.println("Item added = " + item)); // Output: circlet 2

        System.out.println(bilbo.getInventory()); // Output: [ring, circlet]

        inventory.removeItem(bilbo, (item) -> item.equals("ring"));

        System.out.println(bilbo.getInventory()); // Output: [circlet]

        inventory.updateItem(bilbo, (item) -> item.equals("circlet"), (item) -> {
            item.setValue(item.getValue() + 1);

            System.out.println("Item updated = " + item.getName() + ": " + item.getValue()); // Output: circlet: 3

            return item;
        });
    }
}
