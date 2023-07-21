package faang.school.godbless.lord_of_the_rings_rpg;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> feedback) {
        character.getInventory().add(item);
        feedback.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> checkCondition) {
        if (character.getInventory().isEmpty()) {
            System.out.println("В инвенторе, нет предметов");
        }
        for (var item : character.getInventory()) {
            if (checkCondition.test(item)) {
                item.setValue(item.getValue() - 1);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> checkCondition, Function<Item, Item> updatingItem) {
        if (character.getInventory().isEmpty()) {
            System.out.println("В инвенторе, нет предметов");
        }
        for (var item : character.getInventory()) {
            if (checkCondition.test(item)) {
                Item newItem = updatingItem.apply(item);
                character.getInventory().remove(item);
                character.getInventory().add(newItem);
            }
        }
    }

    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));

        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));

        System.out.println(frodo.getInventory().get(0).getValue());

        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory().get(0).getValue());
    }
}
