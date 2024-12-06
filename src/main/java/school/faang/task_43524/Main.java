package school.faang.task_43524;

import school.faang.task_43524.model.Character;
import school.faang.task_43524.model.Item;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(ring, frodo, (Item item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        manager.addItem(ring, frodo, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(
                frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2)
        );

        frodo.getItems().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
