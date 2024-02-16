package faang.school.godbless.LOTRRPG2588;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    private static final String ADD_MESSAGE = "Item was successfully added to your inventory!";

    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Character Bilbo = new Character("Bilbo");
        Item ring = new Item("Copper ring", 5);
        Item crown = new Item("Golden crown", 300);
        Item food = new Item("Fairy Bread", 140);
        Item bow = new Item("Bow", 50);
        Consumer<String> printMessage = System.out::println;
        Predicate<Item> bilboHasIt = item -> Bilbo.getInventory().contains(item);
        Predicate<Item> isCheap = item -> item.getValue() <= 10;
        Function<Item, Item> coverInGold = item -> new Item(item.getName() + "_golden",
                item.getValue() + 250);

        // tests
        inventoryManager.addItem(Bilbo, ring, ADD_MESSAGE, printMessage);
        inventoryManager.addItem(Bilbo, crown, ADD_MESSAGE, printMessage);
        inventoryManager.addItem(Bilbo, food, ADD_MESSAGE, printMessage);
        System.out.println(Bilbo.getInventory());

        inventoryManager.removeItem(Bilbo, food, bilboHasIt);
        inventoryManager.removeItem(Bilbo, bow, bilboHasIt);
        System.out.println(Bilbo.getInventory());

        inventoryManager.updateItem(Bilbo, ring, bilboHasIt, isCheap, coverInGold);
        inventoryManager.updateItem(Bilbo, crown, bilboHasIt, isCheap, coverInGold);
        System.out.println(Bilbo.getInventory());
    }
}