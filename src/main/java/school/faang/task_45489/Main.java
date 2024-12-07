package school.faang.task_45489;

import lombok.extern.slf4j.Slf4j;
import school.faang.task_45489.model.Character;
import school.faang.task_45489.model.Item;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");

        InventoryManager manager = new InventoryManager();

        manager.addItem(Item.RING, frodo, (item) -> {
            log.info("A {} item has been added to {} inventory", item.name(), frodo.getName());
        });

        manager.addItem(Item.SWORD, frodo, (item) -> {
            log.info("A {} item has been added to {} inventory", item.name(), frodo.getName());
        });

        log.info(frodo.getInventory().toString());

        manager.removeItem(frodo, (item) -> item.getValue() > 1300);

        log.info(frodo.getInventory().toString());

        manager.updateItem(
                frodo,
                (item) -> item.getValue() > 100,
                (item) -> Item.SWORD
        );

        log.info(frodo.getInventory().toString());
    }
}
