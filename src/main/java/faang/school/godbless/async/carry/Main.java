package faang.school.godbless.async.carry;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Item> itemsInTheStore = new ArrayList<>();

        itemsInTheStore.add(new Item("Boots of Speed", 42));
        itemsInTheStore.add(new Item("Magic Wand", 78));
        itemsInTheStore.add(new Item("Blink Dagger", 15));
        itemsInTheStore.add(new Item("Force Staff", 91));
        itemsInTheStore.add(new Item("Black King Bar", 63));
        itemsInTheStore.add(new Item("Manta Style", 37));
        itemsInTheStore.add(new Item("Desolator", 24));
        itemsInTheStore.add(new Item("Monkey King Bar", 56));
        itemsInTheStore.add(new Item("Heart of Tarrasque", 83));
        itemsInTheStore.add(new Item("Butterfly", 45));
        itemsInTheStore.add(new Item("Daedalus", 72));
        itemsInTheStore.add(new Item("Divine Rapier", 98));

        Store store = new Store(itemsInTheStore);
        Inventory inventory = new Inventory();

        log.info("Simulation start.");

        log.info("Filling the inventory with some items");

        inventory.addItem(store.buyItem(2).join()).join();
        inventory.addItem(store.buyItem(2).join()).join();
        inventory.addItem(store.buyItem(2).join()).join();

        log.info("The inventory content:");
        inventory.getItems().forEach(item -> log.info(item.toString()));

        var itemA = new Item("Blink Dfdgdagger", 15);
        var itemB = new Item("Force Staff", 91);

        log.info("Combining the " + itemA + " and " + itemB + ".");
        inventory.combineItems(itemA, itemB).join();

        log.info("The inventory content:");
        inventory.getItems().forEach(item -> log.info(item.toString()));

        itemA = new Item("Blink Dagger", 15);

        log.info("Combining the " + itemA + " and " + itemB + ".");
        inventory.combineItems(itemA, itemB).join();

        log.info("The inventory content:");
        inventory.getItems().forEach(item -> log.info(item.toString()));

        store.close();
        inventory.close();
    }
}
