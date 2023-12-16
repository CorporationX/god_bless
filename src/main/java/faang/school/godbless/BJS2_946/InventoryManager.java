package faang.school.godbless.BJS2_946;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void main(String[] args) {
        Character character = new Character(new ArrayList<>());
        Item item1 = new Item("Talisman", 10);
        Item item2 = new Item("Pen", 3);

        addItem(item1, character, item -> System.out.println(item.getName()+" was added to list"));
        addItem(item2, character, item -> System.out.println(item.getName()+" was added to list"));
        removeItem(character, item -> item.getValue()>5);
        updateItem(character, item -> item.getName().equals("Talisman"), item -> new Item(item.getName(), item.getValue() * 2));

        for (Item item : character.getInventory()) {
            System.out.println(item);
        }
    }
    public static void addItem(Item item, Character character, Consumer<Item> consumer){
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> itemPredicate){
        List<Item> result = new ArrayList<>();

        for (Item item : character.getInventory()) {
            if(itemPredicate.test(item)){
                result.add(item);
            }
        }

        character.getInventory().clear();
        character.getInventory().addAll(result);
    }

    public static void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction){
        for (Item item : character.getInventory()) {
            if(itemPredicate.test(item)){
                Item updatedItem = itemFunction.apply(item);
                int indexForNewItem = character.getInventory().indexOf(item);
                character.getInventory().set(indexForNewItem, updatedItem);
            }
        }
    }
}
