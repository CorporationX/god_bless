package lordOfTheRings_811;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {

        List<Item> items = character.getInventory();
        items.removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> items = character.getInventory();
        for (Item i : items) {
            if (predicate.test(i)) {
                function.apply(i);
            }
        }
    }

    public static void main(String[] args) {
        Character pendalf = new Character(new ArrayList<>());
        Item palka = new Item("Палка-ковырялка", 10);
        Item shlyapa = new Item("Шляпа", 10);

        addItem(pendalf, palka, (item) -> System.out.println("Шикарно! Вы добавили герою - " + item.getName()));
        addItem(pendalf, shlyapa, (item) -> System.out.println("Шикарно! Вы добавили герою - " + item.getName()));
        System.out.println(pendalf);

        removeItem(pendalf, (item) -> item.getName().equals("Палка-ковырялка"));
        System.out.println(pendalf);

        updateItem(pendalf, (item) -> item.getName().equals("Шляпа"), (item) -> {
            item.setValue(item.getValue() * 2);
            return item;
        });
        System.out.println(pendalf);
    }
}