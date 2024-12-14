package school.faang.lordof_therings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character knight = new Character("Arthur");
        Item sword = new Item("The Excalibur", 3000);
        Item helmet = new Item("The Golden Horn", 2000);
        Item shield = new Item("The Oak Power", 1500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(knight, sword, (item) -> log.info("{} was added to inventory", item.getName()));
        manager.addItem(knight, helmet, (item) -> log.info("{} was added to inventory", item.getName()));
        manager.addItem(knight, shield, (item) -> log.info("{} was added to inventory", item.getName()));

        manager.removeItem(knight, (item) -> item.getName().equals("The Golden Horn"));

        manager.updateItem(knight, (item) -> item.getName().equals("The Excalibur"),
                (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        knight.getInventory().forEach(item -> log.info("Name >> {} || Value >> {}", item.getName(), item.getValue()));
    }
}
