package school.faang.lord_of_the_rings_rpg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> log.info("{} был добавлен в инвентарь.", item.name()));

        manager.removeItem(frodo, (item) -> item.name().contains("Ring"));

        manager.addItem(frodo, ring, (item) -> log.info("{} снова добавлен.", item.name()));
        manager.updateItem(frodo, (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));

        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));

    }
}
