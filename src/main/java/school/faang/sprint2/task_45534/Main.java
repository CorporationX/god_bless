package school.faang.sprint2.task_45534;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Character dmitry = new Character("Dmitry");
        InventoryManager dmitryInventory = new InventoryManager(dmitry);

        Item ring = new Item("Ring", 40);
        Item knife = new Item("Knife", 79);
        Item helmet = new Item("Helmet", 100);

        dmitryInventory.addItem(ring, (item) -> System.out.println("Added: " + item));
        dmitryInventory.addItem(knife, (item) -> System.out.println("Added: " + item));
        dmitryInventory.addItem(helmet, (item) -> System.out.println("Added: " + item));

        dmitryInventory.printAllItems();

        dmitryInventory.removeItem((item) -> item.getName().equals("Knife"));

        dmitryInventory.printAllItems();

        dmitryInventory.updateItem((item) -> Objects.equals(item.getName(), "Helmet"), (item) ->
                        new Item(item.getName(), item.getValue() * 2));

        dmitryInventory.printAllItems();

    }
}
