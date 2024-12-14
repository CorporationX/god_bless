package school.faang.task_45658;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        List<Item> items = new ArrayList<>(List.of(
                new Item("Меч", 500),
                new Item("Посох", 300),
                new Item("Кинжал", 200)
        ));

        Character character = new Character(items);

        Consumer<Item> action = (item) -> System.out.println("Добавлен новый предмет: " + item);

        Item newItem = new Item("НОВЫЙ ПРЕДМЕТ", 100);

        System.out.println("--- Добавляем предмет --- ");
        inventoryManager.addItem(newItem, character,  action);

        System.out.println("\nТекущий инвентарь после добавления:");
        character.getItemList().forEach(System.out::println);

        System.out.println("\n--- Удаляем предмет ---");
        inventoryManager.removeItem(newItem, character, item -> item.getName().equals("НОВЫЙ ПРЕДМЕТ"));

        System.out.println("\nТекущий инвентарь после удаления:");
        character.getItemList().forEach(System.out::println);

        Function<Item, Item> updateFunction = (item) -> {
            item.setValue(item.getValue() * 2);
            return item;
        };

        System.out.println("\n--- Удвоение стоимости предметов с ценой > 400 ---");
        inventoryManager.updateItem(character, updateFunction, item -> item.getValue() > 400);

        System.out.println("\nТекущий инвентарь после обновления:");
        character.getItemList().forEach(System.out::println);

    }
}
