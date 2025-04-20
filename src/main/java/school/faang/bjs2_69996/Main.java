package school.faang.bjs2_69996;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item sword = new Item("The One Sword", 500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> getInfo("{} was added to inventory.", item));
        manager.addItem(frodo, sword, (item) -> getInfo("{} was added to inventory.", item));
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));

        manager.removeItem(frodo, (item) -> item.name().contains("Ring"));
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));

        manager.addItem(frodo, ring, (item) -> getInfo("{} added again.", item));
        manager.updateItem(
                frodo,
                (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2)
        );
        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));
    }

    private static void getInfo(String s, Item item) {
        log.info(s, item.name());
    }
}