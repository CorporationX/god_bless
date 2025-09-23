package school.faang.lord_of_the_rings;

import java.util.ArrayList;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class Main {
    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", new ArrayList<>());
        Character frodo = new Character("Frodo", new ArrayList<>());

        Item sword = new Item("Narsil", 13_000);
        Item ring = new Item("The One Ring", 8_000);

        InventoryManager inventoryManager = new InventoryManager();

        //Добавляем предметы в инвентарь
        inventoryManager.addItem(frodo, ring, (item) ->
                System.out.printf("%s был добавлен в инвентарь.\n", item.getName()));
        inventoryManager.addItem(aragorn, sword, (item) ->
                System.out.printf("%s был добавлен в инвентарь.\n", item.getName()));

        //Удаляем предмет из инвентаря с именем, содержащим "Ring"
        inventoryManager.removeItem(frodo, (item) -> item.getName().contains("Ring"));

        //Добавляем предмет обратно и обновляем его стоимость
        inventoryManager.addItem(frodo, ring, (item) ->
                System.out.printf("%s снова добавлен.\n", item.getName()));
        inventoryManager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        //Выводим результат
        frodo.getInventory().forEach(item ->
                System.out.println(item.getName() + ": " + item.getValue()));
    }
}