package school.faang.bjs2_80288;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class Main {
    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager();
        Character hero = new Character("Steve");

        Item earth = new Item("Земля", 64);
        Item cobblestone = new Item("Булыжник", 32);
        Item seed = new Item("Семечка", 12);
        Item dirt = new Item("Грязь", 10);

        Consumer<Item> action = item -> log.info("Предмет %s был добавлен в инвентарь".formatted(item.getName()));

        inventoryManager.addItem(hero, earth, action);
        inventoryManager.removeItem(hero, item -> item.getValue() == 13);

        inventoryManager.updateItem(hero,
                item -> item.getName().toLowerCase().contains("земля"),
                item -> new Item("Грязь", 1)
        );

        inventoryManager.addItem(hero, dirt, action);
        inventoryManager.addItem(hero, seed, action);
        inventoryManager.addItem(hero, cobblestone, action);
        inventoryManager.removeItem(hero, item -> item.getValue() == 10);

        hero.getInventory().forEach(
                item -> log.info("Предмет: %s; Кол-во: %s".formatted(item.getName(), item.getValue()))
        );

    }
}
