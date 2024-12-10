package school.faang.sprint2.task45800;

import school.faang.sprint2.task45800.manager.InventoryManager;
import school.faang.sprint2.task45800.model.Character;
import school.faang.sprint2.task45800.model.Item;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Item ring1 = new Item("The First Ring", 1000);
        Item ring2 = new Item("The Second Ring", 1000);
        Item ring3 = new Item("The Third Ring", 1000);
        Character gendalf = new Character("Gendalf");
        addItem(manager, gendalf, ring1);
        addItem(manager, gendalf, ring2);
        addItem(manager, gendalf, ring3);

        Item ring4 = new Item("The Fourth Ring", 1000);
        Item ring5 = new Item("The Fifth Ring", 1000);
        Item ring6 = new Item("The Sixth Ring", 1000);
        Character frodo = new Character("Frodo");
        addItem(manager, frodo, ring4);
        addItem(manager, frodo, ring5);
        addItem(manager, frodo, ring6);

        Item sword = new Item("The Sword", 500);
        Character aragorn = new Character("Aragorn");
        addItem(manager, aragorn, sword);

        Item bow = new Item("The Bow", 400);
        Character legolas = new Character("Legolas");
        addItem(manager, legolas, bow);

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

    private static void addItem(InventoryManager manager, Character character, Item itemIn) {
        Consumer<Item> itemAdded = (item) -> System.out.println(item.getName() + " был добавлен в инвентарь.");
        manager.addItem(character, itemIn, itemAdded);
    }
}
