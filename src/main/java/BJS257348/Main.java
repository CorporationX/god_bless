package BJS257348;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character seriousSam = new Character("Serious Sam");
        Item miniGun = new Item("Mini Gun", 10000);

        InventoryManager manager = new InventoryManager();
        log.info(" added methods : ");
        manager.addItem(seriousSam, miniGun, (item) ->
                System.out.println("Character: " + seriousSam.getName() + " Was added: " + item.getName()));
        manager.addItem(seriousSam, miniGun, (item) ->
                System.out.println("Character: " + seriousSam.getName() + " Was added: " + item.getName()));
        manager.addItem(seriousSam, miniGun, (item) ->
                System.out.println("Character: " + seriousSam.getName() + " Was added: " + item.getName()));
        log.info(" after adding a new items : ");
        seriousSam.getInventory().forEach((item -> System.out.println("Item: " + item.getName())));
        log.info(" remove method : ");
        manager.removeItem(seriousSam, miniGun, (item) -> item.getName().equals("Mini Gun"));
        log.info(" after remove : ");
        seriousSam.getInventory().forEach((item -> System.out.println("Item: " + item.getName())));
        log.info(" update method : ");
        manager.updateItem(seriousSam, (item) -> item.getName().equals("Mini Gun"),
                (item) -> new Item(miniGun.getName(), miniGun.getValue() * 2));
        log.info(" after update : ");
        seriousSam.getInventory().forEach((item ->
                System.out.println("Item: " + item.getName() + " : " + item.getValue())));
    }

}
