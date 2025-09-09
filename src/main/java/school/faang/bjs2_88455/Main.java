package school.faang.bjs2_88455;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Item itemRing = new Item("ring", 10000000);
        Item itemHelmet = new Item("Helmet", 500000);
        Item itemShield = new Item("Shield", 999999);
        Item itemRingFake = new Item("ring", 100);
        Character frodo = new Character("frodo");

        Consumer<Item> consumerAdd = item -> {
            frodo.getInventory().add(item);
            System.out.printf("%s - Item has been added \n", item);
        };

        manager.addItem(itemRing, consumerAdd);
        manager.addItem(itemHelmet, consumerAdd);
        manager.addItem(itemRingFake, consumerAdd);
        manager.addItem(itemShield, consumerAdd);

        Predicate<Item> predicateForRemove = item -> {
            if (Objects.equals(item.getName(), "ring")) {
                return item.getValue() >= 1000000;
            }
            return true;

        };

        manager.removeItem(frodo, predicateForRemove);

        Consumer<Item> consumerGeneralDepreciation = item -> item.setValue((item.getValue() * 2.5));

        manager.updateItem(frodo, consumerGeneralDepreciation);

        Consumer<ArrayList<Item>> consumerPrintItemsChar = items -> items.forEach(System.out::println);

        manager.printAllItems(frodo, consumerPrintItemsChar);

    }
}
