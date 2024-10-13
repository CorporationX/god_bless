package school.faang.BJS2_33773;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        frodo.printItems();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        frodo.printItems();
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        frodo.printItems();
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        frodo.printItems();
        manager.updateItem(frodo,
                (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
        frodo.printItems();
    }
}
