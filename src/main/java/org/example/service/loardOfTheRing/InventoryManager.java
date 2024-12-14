package org.example.service.loardOfTheRing;

import org.example.loardOfTheRing.Character;
import org.example.loardOfTheRing.Item;

import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public static void addItem(Character character, Item item, Consumer<Item> process) {
        character.getInventory().add(item);
        process.accept(item);
    }

    public static void removeItem(Character character, Predicate<Item> condition) {
        for(Item item : character.getInventory()){
            if (condition.test(item)) {
                character.getInventory().remove(item);
            }
        }
    }

    public static void updateItem(Character character, Predicate<Item> condition, Consumer<Item> process) {
        for(Item item : character.getInventory()){
            if(condition.test(item)){
                process.accept(item);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Character firstCharacter = new Character("Zhubanysh", new LinkedList<>());
        Item ring = new Item("The one ring", 3000);

        addItem(firstCharacter, ring, process -> System.out.println("To " + firstCharacter.getName() + " added ring -> " + ring.getName()));

        updateItem(firstCharacter, condition -> firstCharacter.getName().equals("Zhubanysh"),
                (item) -> item.setValue(item.getValue() * 5));

        removeItem(firstCharacter, item -> item.getName().equals("Zhubanysh"));
    }
}
