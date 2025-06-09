package school.faang.bjs2_80288;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class Main {
    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager();
        Character hero = new Character("Steve");

        Item item1 = new Item("Земля", 64);
        Item item2 = new Item("Булыжник", 32);
        Item item3 = new Item("Семечка", 12);
        Item item4 = new Item("Грязь", 10);

        Consumer<Item> action = item -> log.info("Предмет %s был добавлен в инвентарь".formatted(item.getName()));

        inventoryManager.addItem(hero, item1, action);
        inventoryManager.removeItem(hero, item -> item.getValue() == 13);

        inventoryManager.updateItem(hero,
                item -> item.getName().toLowerCase().contains("земля"),
                item -> new Item("Грязь", 1)
        );

        inventoryManager.addItem(hero, item4, action);
        inventoryManager.addItem(hero, item3, action);
        inventoryManager.addItem(hero, item2, action);

        hero.getInventory().forEach(
                item -> log.info("Предмет: %s; Кол-во: %s".formatted(item.getName(), item.getValue()))
        );

    }
}
