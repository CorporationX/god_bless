package faang.school.godbless.BJS2_21257;

import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Character character = new Character("Robert", new HashSet<>());
        Consumer<Item> action = item -> System.out.printf("Добавлен новый предмет: %s%n", item);
        Predicate<Item> condition1 = item -> item.getValue() <= 50;
        Predicate<Item> condition2 = item -> {
            String[] words = item.getName().split(" ");
            return words.length >= 2;
        };
        Function<Item, Item> updateAction = item -> new Item(item.getName(), item.getValue() + 50);

        InventoryManager.addItem(character, new Item("Призыв", 35), action);
        InventoryManager.addItem(character, new Item("Клонирование", 55), action);
        InventoryManager.addItem(character, new Item("Эдо тенсей", 75), action);
        InventoryManager.addItem(character, new Item("Рассенган", 20), action);
        System.out.println(character.getItems());
        System.out.println();

        InventoryManager.removeItem(character, condition2);
        System.out.println(character.getItems());
        System.out.println();

        InventoryManager.updateItem(character, condition1, updateAction);
        System.out.println(character.getItems());
    }
}
