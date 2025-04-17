package school.faang.lordoftheringsrpg;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item theRing = new Item("The One Ring", 1000);
        Item ringOfGaladriel = new Item("The Ring of Galadriel", 500);
        Item mithrilChainmail = new Item("mithril chainmail", 300);

        InventoryManager manager = new InventoryManager();

        BiConsumer<Character, Item> notificationForAddition = (character, item) -> System.out.println(item.getName()
                + " was added to inventory of " + character.getName());

        manager.addItem(frodo, theRing, notificationForAddition);
        manager.addItem(frodo, ringOfGaladriel, notificationForAddition);
        manager.addItem(frodo, mithrilChainmail, notificationForAddition);

        frodo.getInventory().forEach(item -> log.info(item.getName() + ": " + item.getValue()));
        System.out.println(" ");

        manager.removeItemsIfSatisfyCondition(frodo, (item) -> item.getName().contains("Ring"));

        manager.addItem(frodo, theRing, (character, item) -> System.out.println(item.getName()
                + " was added again " + character.getName()));

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2));

        frodo.getInventory().forEach(item -> log.info(item.getName() + ": " + item.getValue()));
    }
}
