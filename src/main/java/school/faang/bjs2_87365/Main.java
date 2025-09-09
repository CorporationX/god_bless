package school.faang.bjs2_87365;

import school.faang.bjs2_87365.character.Character;
import school.faang.bjs2_87365.character.InventoryManager;
import school.faang.bjs2_87365.character.Item;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Item frodoMail = new Item("Мифриловая кольчуга Фродо", 20000);
        Item anduril = new Item("Неистовый Андурил", 150000);
        Item ringOfOmnipotence = new Item("Единое Кольцо", 1000000);

        Character frodo = new Character("Frodo", new ArrayList<>());

        Consumer<Item> additionAction = item -> System.out.println("Предмет \"" + item.name() +
                "\" добавлен в инвентарь");
        InventoryManager.addItem(frodo, frodoMail, additionAction);
        InventoryManager.addItem(frodo, anduril, additionAction);
        InventoryManager.addItem(frodo, ringOfOmnipotence, additionAction);
        System.out.println();

        System.out.println("Инвентарь " + frodo.name() + " после добавления предметов:");
        frodo.inventory().forEach(System.out::println);
        System.out.println();

        Predicate<Item> itemCondition = item -> item.value() >= 150000;
        InventoryManager.removeItem(frodo, anduril, itemCondition);
        InventoryManager.removeItem(frodo, ringOfOmnipotence, itemCondition);

        System.out.println("Инвентарь " + frodo.name() + " после удаления предметов:");
        frodo.inventory().forEach(System.out::println);
        System.out.println();

        Function<Item, Item> itemUpdater = item -> new Item("Кольцо Всевластья", Integer.MAX_VALUE);
        InventoryManager.updateItem(frodo, frodoMail, itemUpdater);

        System.out.println("Инвентарь " + frodo.name() + " после обновления предметов:");
        frodo.inventory().forEach(System.out::println);
    }
}
