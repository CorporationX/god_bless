package school.faang.lord_of_rings_rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        //Adding an item to inventory
        addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to inventory"));
        //Removing an item  from inventory
        removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        //Adding an item back to inventory
        addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added again."));
        updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        //Checking the result
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }

    public static void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> updater) {
        List<Item> characterInventory = character.getInventory();
        for (int i = 0; i < characterInventory.size(); i++) {
            Item item = characterInventory.get(i);
            if (predicate.test(item)) {
                characterInventory.set(i, updater.apply(item));
            }
        }
    }
}