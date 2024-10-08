package bjs2_33700;

import java.util.Collections;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Character character = new Character();
        InventoryManager manager = new InventoryManager();

        Item item1 = new Item("item1", 10);
        Item item2 = new Item("item2", 130);
        Item item3 = new Item("item3", 55);
        Item item4 = new Item("item4", 89);
        Item item5 = new Item("item5", 77);

        Collections.addAll(character.getInventory(), item1, item2, item3, item4);

        manager.addItem(character, System.out::println, item5);
        System.out.println(character.getInventory());

        manager.removeItem(character, item -> item.getValue() > 80);
        System.out.println(character.getInventory());

        Function<Item, Item> doubleValue = item -> {
            Integer newValue = 2 * item.getValue();
            item.setValue(newValue);
            return item;
        };

        manager.updateItem(
                character,
                item -> item.getName().endsWith("1"),
                doubleValue);
        System.out.println(character.getInventory());
    }
}
