package school.faang.lambda.lord;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    InventoryManager inventoryManager = new InventoryManager();
    Character bilbo = new Character("Bilbo");

    public static void main(String[] args) {

        Main main = new Main();

        Item item1 = new Item("Knife", 1000);
        Item item2 = new Item("Ring", 200);
        Item item3 = new Item("Ring", 5000);

        BiConsumer<Character, Item> addItem = (character, itemCharacter) ->
        {
            character.getInventory().add(itemCharacter);
            System.out.printf("\nAdded item %s", itemCharacter);
        };
        Predicate<Item> condition = item -> item.getName().equals("Ring");
        Consumer<Item> updateAction = item -> item.setValue(item.getValue() + 20);
        Consumer<Character> listAction = character -> System.out.println(character.getInventory());

        main.inventoryManager.addItem(main.bilbo, item1, addItem);
        main.inventoryManager.addItem(main.bilbo, item2, addItem);
        main.inventoryManager.addItem(main.bilbo, item3, addItem);
        main.doSomething(main.bilbo, listAction);

        main.inventoryManager.updateItem(main.bilbo, condition, updateAction);
        main.doSomething(main.bilbo, listAction);

        main.inventoryManager.removeItem(main.bilbo, condition);
        main.doSomething(main.bilbo, listAction);
    }

    public void doSomething(Character character, Consumer<Character> action) {
        action.accept(character);
    }
}