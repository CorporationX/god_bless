package school.faang.lambda.lotr_rpg;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Consumer;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);
        Item gendalf = new Item("Gendalf", 1);
        Item mithrilArmor = new Item("Mithril Armor", 10000);

        InventoryManager manager = new InventoryManager();

        Consumer<Item> onAddItemMsg = (item) -> log.info("{} был добавлен в инвентарь.", item.name());

        manager.addItem(frodo, ring, onAddItemMsg);
        manager.addItem(frodo, gendalf, onAddItemMsg);
        manager.addItem(frodo, mithrilArmor, onAddItemMsg);

        manager.removeItem(frodo, (item) -> item.name().contains("Ring"));

        manager.addItem(frodo, ring, (item) -> log.info("{} снова добавлен.", item.name()));
        manager.updateItem(frodo, (item) -> Objects.equals(item.name(), "The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2));
        manager.updateItem(frodo, (item) -> Objects.equals(item.name(), "Gendalf"),
                (item) -> new Item(item.name(), item.value() * 100000));

        frodo.getInventory().forEach(item -> log.info("{}: {}", item.name(), item.value()));
    }
}
