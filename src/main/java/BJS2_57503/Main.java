package BJS2_57503;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> log.info("{} был добавлен в инвентарь.", item.getName()));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.addItem(frodo, ring, (item) -> log.info("{} снова добавлен.", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                           (item) -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item -> log.info("{}: {}", item.getName(), item.getValue()));
    }
}
