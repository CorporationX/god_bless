package school.faang.sprint2.task45800;

import school.faang.sprint2.task45800.manager.InventoryManager;
import school.faang.sprint2.task45800.model.Character;
import school.faang.sprint2.task45800.model.Item;

public class Main {
    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Character gendalf = new Character("Gendalf");
        Character aragorn = new Character("Aragorn");
        Character legolas = new Character("Legolas");

        Item ring1 = new Item("The First Ring", 1000);
        Item ring2 = new Item("The Second Ring", 1000);
        Item ring3 = new Item("The Third Ring", 1000);
        Item ring4 = new Item("The Fourth Ring", 1000);
        Item ring5 = new Item("The Fifth Ring", 1000);
        Item ring6 = new Item("The Sixth Ring", 1000);
        Item sword = new Item("The Sword", 500);
        Item bow = new Item("The Bow", 400);

        InventoryManager manager = new InventoryManager();

        manager.addItem(gendalf, ring1, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(gendalf, ring2, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(gendalf, ring3, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, ring4, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, ring5, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, ring6, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(aragorn, sword, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(legolas, bow, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        manager.removeItem(frodo,
                (item) -> item.getName().equals("The Fourth Ring"));

        manager.addItem(frodo,
                ring4,
                (item) -> System.out.println(item.getName() + " снова добавлен."));

        manager.updateItem(frodo,
                (item) -> item.getName().equals("The Fourth Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        manager.removeItem(frodo,
                (item) -> item.getName().equals("The Sixth Ring"));

        manager.updateItem(legolas,
                (item) -> item.getName().equals("The Bow"),
                (item) -> new Item(item.getName(), item.getValue() * 3));

        System.out.println("Frodo inventory:");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
        System.out.println("Gendalf inventory:");
        gendalf.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
        System.out.println("Aragorn inventory:");
        aragorn.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
        System.out.println("Legolas inventory:");
        legolas.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
