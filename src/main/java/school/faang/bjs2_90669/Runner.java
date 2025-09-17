package school.faang.bjs2_90669;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final int LEGENDARY_ITEM_VALUE = 999;
    private static final List<Item> STARTER_KIT = List.of(
            new Item("Ботинки", 100),
            new Item("Рубашка", 500),
            new Item("Штаны", 1000)
    );

    public static void main(String[] args) {
        Character frodo = new Character("Frodo", new ArrayList<>(STARTER_KIT));
        InventoryManager inventory = new InventoryManager();

        inventory.addItem(frodo, new Item("Кольцо", 1000), item ->
                System.out.println("Добавлен предмет: " + item));

        inventory.addItem(frodo, new Item("Пожилая заточка", 500), item ->
                System.out.println("Добавлен предмет: " + item));
        inventory.removeItem(frodo, item -> item.getName().contains("Пожилая заточка"), item ->
                System.out.println("Удален предмет: " + item));
        inventory.addItem(frodo, new Item("Пожилая заточка", 2), item ->
                System.out.println("Добавлен предмет: " + item));

        inventory.removeItem(frodo, item -> item.getName().equalsIgnoreCase("Кольцо"),  item ->
                System.out.println("Удален предмет: " + item));
        inventory.updateItem(frodo,
                item -> item.getName().equals("Пожилая заточка"),
                item -> new Item(item.getName(),  1488));

        System.out.println(frodo);

        inventory.removeItem(frodo, item -> item.getValue() > LEGENDARY_ITEM_VALUE, item ->
                System.out.printf("Удален предмет стоимостью больше %d: %s ", LEGENDARY_ITEM_VALUE, item));
    }
}

