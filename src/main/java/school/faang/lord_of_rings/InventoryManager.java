package school.faang.lord_of_rings;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        character.getInventory().removeIf(itemPredicate);
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {

        for (Item item : character.getInventory()) {
            if (itemPredicate.test(item)) {
                item.setValue(itemFunction.apply(item).getValue());
            }
        }

        character.getInventory().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Character indian = new Character("Indian");
        Item ring = new Item("The Sharpest Sword", 100);
        InventoryManager manager = new InventoryManager();

        manager.addItem(indian, ring, item -> System.out.println(new StringBuilder(item.getName())
                .append(" added to inventory and itemConsumer can do everything with this item")));

        manager.removeItem(indian, item -> item.getName().equals("The Sharpest Sword"));

        manager.addItem(indian, ring, item -> System.out.println(item.getName() + " added again"));

        manager.updateItem(indian, item -> item.getName().equals("The Sharpest Sword"),
                item -> new Item(item.getName(), item.getValue() * 2));

        indian.getInventory().forEach(item -> System.out.println(new StringBuilder(item.getName())
                .append(": ").append(item.getValue())));
    }
}
