package school.faang.bjs2_70098;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> log.info("{} добавлен в инвентарь {}", item, frodo.getName()));

        log.info(String.valueOf(frodo.getInventory()));
        manager.removeItem(frodo, item -> item.getName().contains("Ring"));
        log.info(String.valueOf(frodo.getInventory()));

        manager.addItem(frodo, ring, item -> log.info("{} добавлен в инвентарь {}", item, frodo.getName()));
        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));
        log.info(String.valueOf(frodo.getInventory()));
    }
}
