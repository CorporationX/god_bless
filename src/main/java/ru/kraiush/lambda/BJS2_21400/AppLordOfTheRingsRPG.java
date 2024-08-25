package ru.kraiush.lambda.BJS2_21400;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AppLordOfTheRingsRPG {

    public static void main(String[] args) {

        List<Character> listCharacters= getCharacters();
        List<Item> listItems= getItems();

        Consumer<Character> printCharacters= item-> System.out.println(item);
        listCharacters.forEach(printCharacters);

        Consumer<Item> printItems= item-> System.out.println(item);
        listItems.forEach(printItems);

        InventoryManager manager = new InventoryManager();

        List<InventoryManager> listManagers= new ArrayList<>();

        manager.addItem(listCharacters.get(0), listItems.get(0));

        Consumer<Object> consumer = ConsumerPrint::printValue;;
        consumer.accept(77);

        consumer = manager.addItem(listCharacters.get(0), listItems.get(1), (item) -> System.out.println(item.getName() + " was added to the inventory."));

//        Consumer<String> consumer = s -> System.out.println(s);
//        consumer.andThen(s -> System.out.println(s.toUpperCase()));

//        Consumer<InventoryManager> pringManagers= (c, i) -> {
//            manager.addItem(c, i);
//            System.out.println(i.getName() + " was added to the inventory."));
//        }

        listManagers.add(manager.addItem(listCharacters.get(0), listItems.get(0)));
        System.out.println("\nlistManagers: " + listManagers);


//        Consumer<String> add=manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " was added to the inventory."));
//        add.accept();
    }

    private static List<Character> getCharacters() {

        Character frodo = new Character("Frodo Baggins");
        Character gendalf= new Character("Gendalf");
        Character aragorn= new Character("Aragorn");
        Character baromir = new Character("Baromir");
        Character legolas= new Character("Legolas");
        Character galadriel= new Character("Galadriel");
        Character saruman= new Character("Saruman");

        List<Character> listCharacters= new ArrayList<>();
        listCharacters.add(frodo);
        listCharacters.add(aragorn);
        listCharacters.add(gendalf);
        listCharacters.add(baromir);
        listCharacters.add(legolas);
        listCharacters.add(galadriel);
        listCharacters.add(saruman);

        return listCharacters;
    }

    private static List<Item> getItems() {

        Item ring = new Item("The One Ring", 1000);
        Item triangle = new Item("Triangle of Wise", 7000);
        Item handkerchief= new Item("Handkerchief of Adjility", 300);
        Item boots= new Item("Walking Boots", 7000);
        
        List<Item> listItems= new ArrayList<>();
        listItems.add(ring);
        listItems.add(triangle);
        listItems.add(handkerchief);
        listItems.add(boots);
        
        return listItems;    }
}
