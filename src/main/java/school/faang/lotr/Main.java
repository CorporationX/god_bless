package school.faang.lotr;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " Добавлен в инвентарь"));
        manager.updateItem(frodo, (item) -> Objects.equals(item.getName(), ("The One Ring")),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        manager.removeItem(frodo, (item) -> item.getName().contains("Ring"));
    }
}
