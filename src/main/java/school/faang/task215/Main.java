package school.faang.task215;

import school.faang.task215.character.Character;
import school.faang.task215.item.Item;
import school.faang.task215.manager.InventoryManager;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Character firstCharacter = new Character();
        Character secondCharacter = new Character();

        Item firstItem = new Item("The One Ring", 1000);
        Item secondItem = new Item("Knife", 780);
        Item thirdItem = new Item("Meat", 30);

        Consumer<Item> addingItem = item -> System.out.println(item.getName() + " was added to inventory");

        InventoryManager.addItem(firstCharacter, firstItem, addingItem);
        InventoryManager.addItem(firstCharacter, secondItem, addingItem);
        InventoryManager.addItem(secondCharacter, thirdItem, addingItem);

        Predicate<Item> stuffFinder = item -> item.getName().contains("Ring");

        InventoryManager.removeItem(firstCharacter, stuffFinder);
        firstCharacter.getCharacterStuff().forEach(item -> System.out.println(item.getName() + " " + item.getValue()));

        InventoryManager.addItem(firstCharacter, firstItem, addingItem);

        Function<Item, Integer> increaseThePrice = (item) -> item.getValue()*2;

        InventoryManager.updateItem(firstCharacter, stuffFinder, increaseThePrice);
        firstCharacter.getCharacterStuff().forEach(item -> System.out.println(item.getName() + " " + item.getValue()));
    }
}
