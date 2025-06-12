package school.faang.bjs2_80405;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class Application {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, item -> log.info("{} was added to the inventory.", item.getName()));

        manager.removeItem(frodo, item -> item.getName().contains("Ring"));

        manager.addItem(frodo, ring, item -> log.info("{} was added back to the inventory.", item.getName()));

        manager.updateItem(frodo, item -> item.getName().equals("The One Ring"),
                item -> new Item(item.getName(), item.getValue() * 2));

        frodo.getInventory().forEach(item ->
                log.info("{}: {}", item.getName(), item.getValue()));
    }
}