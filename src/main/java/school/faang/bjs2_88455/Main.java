package school.faang.bjs2_88455;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
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
            System.out.printf("%s - Item has been added \n", item);
        };

        manager.addItem(frodo, itemRing, consumerAdd);
        manager.addItem(frodo, itemHelmet, consumerAdd);
        manager.addItem(frodo, itemRingFake, consumerAdd);
        manager.addItem(frodo, itemShield, consumerAdd);

        Predicate<Item> predicateForRemove = item -> (Objects.equals(item.getName(), "ring")
                && item.getValue() < 1000000);


        manager.removeItem(frodo, predicateForRemove);

        Function<Item, Item> function = item -> new Item(item.getName(), item.getValue() * 2.50);

        Predicate<Item> predicateUpdate = item -> Objects.equals(item.getName(), "Helmet")
                || Objects.equals(item.getName(), "Shield");
        manager.updateItem(frodo, predicateUpdate, function);

        Consumer<ArrayList<Item>> consumerPrintItemsChar = items -> items.forEach(System.out::println);

        manager.printAllItems(frodo, consumerPrintItemsChar);

    }
}
