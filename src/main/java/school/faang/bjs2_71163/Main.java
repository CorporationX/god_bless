package school.faang.bjs2_71163;

import java.math.BigDecimal;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", new BigDecimal(1000));

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> System.out.println(item.name() + " has been added to the inventory."));

        manager.removeItem(frodo, item -> item.name().contains("Ring"));

        manager.addItem(frodo, ring, item -> System.out.println(item.name() + " added again."));
        manager.updateItem(frodo, item -> Objects.equals(item.name(),  "The One Ring"),
                item -> new Item(item.name(), item.price().multiply(new BigDecimal(2))));

        frodo.getItems().forEach(item -> System.out.println(item.name() + ": " + item.price()));
    }
}
