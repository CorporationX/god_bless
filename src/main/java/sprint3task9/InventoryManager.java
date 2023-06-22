package sprint3task9;

import lombok.Data;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class InventoryManager {
    public void addItem(Character character, Item item,
                        Consumer<List<Item>> consumer) {
        character.getInventory().add(item);
        //добавляет предмет в инвентарь персонажа
        consumer.accept(character.getInventory());
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        // как сказать что тот самый oddItem, что лежит в листе
        for (Item oddItem : character.getInventory()) {
            if (predicate.test(oddItem)) {
                character.getInventory().remove(oddItem);
            }
        }
        //if (character.getInventory().contains(oddItem)) {
    }

    public void updateItem(Character character, Predicate<Item> predicate,
                           Function<Item, Item> function) {
        for (Item removingItem : character.getInventory()) {
            if (predicate.test(removingItem)) {
                function.apply(removingItem);
            }
        }
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

