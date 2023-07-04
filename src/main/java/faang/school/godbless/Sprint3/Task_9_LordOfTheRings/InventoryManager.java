package faang.school.godbless.Sprint3.Task_9_LordOfTheRings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem (Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem (Character character, Predicate<Item> condition) {
        character.getInventory().removeIf(condition);
    }

    public static void updateItem (Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        character.getInventory().stream()
                .filter(condition)
                .findFirst()
                .ifPresent(item -> character.getInventory().set(character.getInventory().indexOf(item), updater.apply(item)));
    }

    public static void main(String[] args) {

        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

// Добавляем предмет в инвентарь
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

// Удаляем предмет из инвентаря
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

// Обновляем предмет в инвентаре
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
    }
}

