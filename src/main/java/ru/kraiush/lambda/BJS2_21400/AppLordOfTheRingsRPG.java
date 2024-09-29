package ru.kraiush.lambda.BJS2_21400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class AppLordOfTheRingsRPG {

    public static void main(String[] args) {

        Character frodo = new Character("Frodo Baggins");
        Character gendalf= new Character("Gendalf");
        Character aragorn= new Character("Aragorn");

        List<Character> listCharacters= new ArrayList<>();
        listCharacters.add(frodo);
        listCharacters.add(gendalf);
        listCharacters.add(aragorn);

        Item ring = new Item("The Super Ring", 1000);
        Item vessel = new Item("The Vessel of Wisdom", 700);
        Item suit= new Item("Adjility suit", 300);
        Item boots= new Item("Boots runners", 500);

        List<Item> listItems= new ArrayList<>();
        listItems.add(ring);
        listItems.add(vessel);
        listItems.add(suit);
        listItems.add(boots);

        System.out.print(String.join("", Collections.nCopies(80, "-")));
        System.out.println("\n <--- list of Characters + new Character --->");
        Consumer<List<Character>> addCharacter= list -> {
            list.add(new Character("Aloe"));
        };
        Consumer<List<Character>> printCharacter= list -> list.stream()
                .forEach(System.out::println);
        addCharacter.andThen(printCharacter).accept(listCharacters);
        List<InventoryManager> listManagers= new ArrayList<>();

        System.out.println("\n <--- add Items to Characters --->");
        Consumer<List<InventoryManager>> addManager= list -> {
            list.add(InventoryManager.addItemToCharacter(listCharacters.get(0), listItems.get(0)));
            list.add(InventoryManager.addItemToCharacter(listCharacters.get(1), listItems.get(1)));
            list.add(InventoryManager.addItemToCharacter(listCharacters.get(2), listItems.get(2)));
            list.add(InventoryManager.addItemToCharacter(listCharacters.get(3), listItems.get(3)));
        };
        Consumer<List<InventoryManager>> printManager = list -> list.stream()
                .forEach(s -> System.out.println(">>> The <" + s.item.getName() +  "> was added to the inventory <<<" ));
        addManager.andThen(printManager).accept(listManagers);

        System.out.println("\n <--- delete Item from Character --->");
        System.out.println(listCharacters.get(1) + " - " + listItems.get(1));
        listManagers=InventoryManager.deleteItemFromCharecter(listCharacters.get(1), listItems.get(1), listManagers);
        System.out.println("listManagers: " + listManagers);
        System.out.println("listCharacters: " + listCharacters);

        System.out.println("\n <--- change Item --->");
        System.out.println("listManagers before change: " + listManagers);
        System.out.println(listCharacters.get(2) + " : " + listItems.get(2) + " to " + listItems.get(3));
        System.out.println(listCharacters.get(3) + " : " + listItems.get(3) + " to " + listItems.get(2));
        InventoryManager.changeItem(listCharacters.get(2), listItems.get(2), listItems.get(3), listManagers);
        InventoryManager.changeItem(listCharacters.get(3), listItems.get(3), listItems.get(2), listManagers);
        System.out.println("listManagers after change: " + listManagers);

        System.out.println("\n <--- update Item --->");
        InventoryManager.updateItem(listItems.get(0).getName(), listItems);
        System.out.println("updated list of Items: " + listItems);
        System.out.println("listManagers: " + listManagers);
        System.out.print(String.join("", Collections.nCopies(80, "-")));
    }
}
