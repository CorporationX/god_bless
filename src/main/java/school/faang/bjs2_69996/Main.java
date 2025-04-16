package school.faang.bjs2_69996;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item sword = new Item("The One Sword", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> log.info("{} was added to inventory.", item.getName()));
        manager.addItem(frodo, sword, (item) -> log.info("{} was added to inventory.", item.getName()));
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.getName(), item.getValue()));

        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.getName(), item.getValue()));

        manager.addItem(frodo, ring, (item) -> log.info("{} added again.", item.getName()));
        manager.updateItem(frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.getName(), item.getValue()));
    }
}