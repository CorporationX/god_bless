package faang.school.godbless.lord_of_the_rings;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }
    public void removeItem(Character character, Predicate<Item> predicate) {
            character.getInventory().removeIf(predicate);
    }
    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        List<Item> temp = character.getInventory();
        for(int i = 0; i < temp.size(); i++) {
            if(predicate.test(temp.get(i))) {
                Item item = function.apply(temp.get(i));
                temp.set(i, item);
            }
        }
    }

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
        for(Item item : frodo.getInventory()) {
            System.out.println(item.getName());
        }

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        for(Item item : frodo.getInventory()) {
            System.out.println(item.getValue());
        }

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        System.out.println(frodo.getInventory());
    }
}
