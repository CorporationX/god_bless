package school.faang;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Character elf = new Character();
        Item sword = new Item("sword", 100);
        Item ring = new Item("dragon flame", 500);

        manager.addItem(elf, sword, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(elf, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));

        manager.removeItem(elf, item -> item.getName().equals("dragon flame"),
                (item) -> System.out.println(item.getName() + " был удален из инвентаря."));

        manager.updateItem(elf, item -> item.getName().equals("sword"),
                item -> new Item(item.getName(), item.getValue() * 2));

        elf.getInventory().forEach(item -> System.out.println(item.getName() + ":" + item.getValue() + "."));


    }

    public static void addItem(Character character, Item item, Consumer<Item> action) {
        character.getInventory().add(item);
        action.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> condition, Consumer<Item> action) {
        character.getInventory().removeIf(item -> {
            if (condition.test(item)) {
                action.accept(item);
                return true;
            }
            return false;
        });
    }

    public static void updateItem(Character character, Predicate<Item> condition, Function<Item, Item> updater) {
        List<Item> inventory = character.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (condition.test(item)) {
                inventory.set(i, updater.apply(item));
            }
        }
    }
}
