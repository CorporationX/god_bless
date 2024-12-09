package school.faang.task_45496;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Item> inventory = Arrays.asList(
                new Item("Кольцо", 60),
                new Item("Кожанные ботинки", 80),
                new Item("Стальной шлем", 100),
                new Item("Зелье восстановления", 150),
                new Item("Шляпа", 20),
                new Item("Серебрянный мечь", 230)
        );

        Character character = new Character(inventory);
        InventoryManager manager = new InventoryManager(character);

        Item newItem = new Item("Копье", 180);



        Consumer<Item> addItem = item -> {
            System.out.println("Предмет " + item.getName() + "стоимостью " + item.getValue() + "добавлен в инвентарь");
        };



        manager.addItem(character, newItem, addItem);


    }
}
