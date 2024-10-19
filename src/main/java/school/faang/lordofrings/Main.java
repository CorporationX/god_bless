package school.faang.lordofrings;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);
        Item chain = new Item("The Gold Chain", 5000);
        InventoryManager manager = new InventoryManager();


// Add the item to inventory
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to inventory."));
        manager.addItem(frodo, chain, (item) -> System.out.println(item.name() + " was added to inventory."));
// Remove an item from the inventory
        System.out.println(manager.removeItem(frodo, (item) -> item.name().equals("The One Ring")));
        System.out.println(frodo.inventory().get(0));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.name() + " was added to inventory."));
//// Add the item back and update its cost
// manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " added again."));
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"), (item) -> new Item(item.name(), item.value() * 2));

//// Check the result
        frodo.inventory().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}