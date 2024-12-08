package school.faang.task_45483;

import school.faang.task_45483.model.Character;
import school.faang.task_45483.model.Item;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>());
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(ring, frodo, (Item item) -> System.out.println(item.name() + " был добавлен в инвентарь."));
        manager.removeItem(frodo, (item) -> item.name().equals("The One Ring"));

        manager.addItem(ring, frodo, (item) -> System.out.println(item.name() + " снова добавлен."));
        manager.updateItem(
                frodo,
                (item) -> item.name().equals("The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2)
        );

        frodo.items().forEach(item -> System.out.println(item.name() + ": " + item.value()));
    }
}
