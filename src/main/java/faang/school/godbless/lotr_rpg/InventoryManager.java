package faang.school.godbless.lotr_rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Item item, Character character, Consumer<Item> consumer) {
        character.getItems().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> items = character.getItems();
        items.removeIf(predicate);
    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> func) {
        List<Item> items = character.getItems();
        for (Item item : items) {
            if (predicate.test(item)) {
                Item newItem = func.apply(item);
                items.set(items.indexOf(item), newItem);
            }
        }
    }

    public static void main(String[] args) {

        Character character = new Character();
        List<Item> items = new ArrayList<>();

        Item sword = new Item("Sword", 50);
        Item bow = new Item("Bow", 30);
        Item necklace = new Item("Necklace", 45);

        items.add(sword);
        items.add(bow);

        character.setItems(items);

        addItem(necklace, character, (item) ->
                System.out.println(item.getName() + " was added to inventory!"));
        removeItem(character, (item) -> item.getName().equals("Sword"));
        updateItem(character, (item) -> item.getName().equals("Bow"),
                (item) -> new Item(item.getName(), item.getValue() + 10));

        for (Item item : character.getItems()) {
            System.out.println(item);
        }
    }
}
