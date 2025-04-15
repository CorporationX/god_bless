package school.faang.bjs2_70001;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item hat = new Item("The One Hat", 3000);

        manager.addItem(frodo, ring, (item) -> log.info("{} added into Inventory.", item.name()));
        manager.addItem(frodo, hat, (item) -> log.info("{} added into Inventory.", item.name()));

        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));

        log.info("remove {}", ring.name());
        manager.removeItem(frodo, (item) -> item.name().contains("Ring"));
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));

        manager.addItem(frodo, ring, (item) -> log.info("{} added again.", item.name()));
        manager.updateItem(frodo,
            (item) -> item.name().equals("The One Ring"),
            (item) -> new Item(item.name(), item.value() * 2)
        );
        manager.updateItem(frodo,
            (item) -> item.name().equals("The One Hat"),
            (item) -> new Item(item.name(), item.value() * 3)
        );

        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));
    }
}
