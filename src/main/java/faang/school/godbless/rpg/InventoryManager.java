package faang.school.godbless.rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(
                frodo,
                ring,
                (item) -> System.out.println(item.getName() + " was added to the inventory")
        );


        manager.updateItem(
                frodo,
                item -> item.getName().equals("The One ring"),
                item -> new Item(item.getName(), item.getValue() * 2)
        );

        frodo.getInventory().forEach(item ->
                System.out.println("Frodo after update item: " +
                        item.getName() + " / " + item.getValue())
        );

        manager.removeItem(
                frodo,
                (item) -> item.getName().equals("The One ring")
        );

    }

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item item = character.getInventory().get(i);
            if (predicate.test(item)) {
                character.getInventory().set(i, function.apply(item));
                break;
            }
        }
    }
}
