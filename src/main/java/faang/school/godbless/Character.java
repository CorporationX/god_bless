package faang.school.godbless;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;


public class Character {
    List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        if(name.isBlank()){
            throw new IllegalArgumentException("Name can't be empty.");
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

    public void updateItemIf(Predicate<Item> condition, Function<Item, Item> update) {
        int indexItem = 0;
        for (Item item : inventory) {

            if (condition.test(item)) {
                Item updatedItem = update.apply(item);
                inventory.set(indexItem,updatedItem);
            }
            indexItem++;
        }
    }
}

