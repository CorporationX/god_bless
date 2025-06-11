package school.faang.rpgSystem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryTesting {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item stick = new Item("stick", 10);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, stick, (item) -> log.info("{} был добавлен в инвентарь.", item.getName()));

        manager.removeItem(frodo, (item) -> item.getName().contains("stick"));

        manager.addItem(frodo, stick, (item) -> log.info("{} снова добавлен.", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("stick"), (item) ->
                new Item(item.getName(), item.getValue() * 2));

        frodo.getItems().forEach(item -> log.info("{}: {}", item.getName(), item.getValue()));
    }
}
