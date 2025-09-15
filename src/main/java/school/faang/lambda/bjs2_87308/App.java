package school.faang.lambda.bjs2_87308;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Item ring = new Item("Ring", 1000);
        Item bracelet = new Item("Bracelet", 2000);
        Item watch = new Item("Watch", 3400);


        Character ilonCharacter = new Character("Ilon", new ArrayList<>(Arrays.asList(ring, bracelet)));

        InventoryManager inventoryManager = new InventoryManager();

        System.out.println("Изначальный список предметов");
        System.out.println(ilonCharacter.getItems());

        inventoryManager.addItem(ilonCharacter, watch, item ->
                System.out.printf("Item %s was added to character %s\n", watch.getName(), ilonCharacter.getName()));

        inventoryManager.addItem(ilonCharacter, bracelet, item ->
                System.out.printf("Item %s was added to character %s\n", bracelet.getName(), ilonCharacter.getName()));

        System.out.println("\nПроверка, что добавился item watch и не задублировался item bracelet");
        System.out.println(ilonCharacter.getItems());

        inventoryManager.updateItem(ilonCharacter, item -> item.equals(watch), item -> {
            item.setName(item.getName().toUpperCase() + " modified item");
            return item;
        });

        Item glasses = new Item("Glasses", 3000);

        inventoryManager.updateItem(ilonCharacter, item -> item.equals(glasses), item -> {
            item.setName(item.getName().toUpperCase() + " modified item");
            return item;
        });

        System.out.println("\nПроверка, items после редактирования");
        System.out.println(ilonCharacter.getItems());

        Item gloves = new Item("Gloves", 1500);

        inventoryManager.removeItem(ilonCharacter, item -> item.getValue() > 900 && item.equals(ring));
        inventoryManager.removeItem(ilonCharacter, item -> item.getValue() < 1000 && item.equals(bracelet));
        inventoryManager.removeItem(ilonCharacter, item -> item.getValue() == 1500 && item.equals(gloves));

        System.out.println("\nПроверка, items после удаления");
        System.out.println(ilonCharacter.getItems());
    }
}