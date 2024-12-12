package school.faang.task_45514;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        InventoryManager manager = new InventoryManager();
        addItemsAndCharacters(manager, characters);
        removeItems(manager, characters);
        addItemAndUpdate(manager, characters);
        printAllChatacters(characters);
    }

    private static void printAllChatacters(List<Character> characters) {
        for (Character character : characters) {
            System.out.println(String.format("Персонаж: %s в своем инвентаре имеет следующие предметы: %s",
                    character.getName(), character.getInventory().toString()));
        }
    }

    private static void addItemAndUpdate(InventoryManager manager, List<Character> characters) {
        if (characters.isEmpty()) {
            return;
        }
        Character character = characters.stream().filter(charact -> charact.getName().equals("Frodo")).findAny().get();
        Item ring = new Item("The One Ring", 800);

        manager.addItem(character, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(character, (item) -> item.getName().equals("The One Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));
    }

    private static void removeItems(InventoryManager manager, List<Character> characters) {
        if (characters.isEmpty()) {
            return;
        }

        Character character = characters.stream().filter(charact -> charact.getName().equals("Frodo")).findAny().get();
        manager.removeItem(character, (item) -> item.getName().equals("The One Ring"));
    }

    private static void addItemsAndCharacters(InventoryManager manager, List<Character> characters) {
        Character hobbitFrodo = new Character("Frodo");
        Character hobbitSam = new Character("Sam");

        characters.add(hobbitFrodo);
        characters.add(hobbitSam);

        manager.addItem(hobbitFrodo, new Item("The One Ring", 1000), (item) -> System.out.println(String
                .format("%s был добавлен в инвентарь к %s.", item.getName(), hobbitFrodo.getName())));
        manager.addItem(hobbitFrodo, new Item("Staff", 10), (item) -> System.out.println(String
                .format("%s был добавлен в инвентарь к %s.", item.getName(), hobbitFrodo.getName())));
        manager.addItem(hobbitFrodo, new Item("Food", 500), (item) -> System.out.println(String
                .format("%s был добавлен в инвентарь к %s.", item.getName(), hobbitFrodo.getName())));

        manager.addItem(hobbitSam, new Item("Pajamas", 1000), (item) -> System.out.println(String
                .format("%s был добавлен в инвентарь к %s.", item.getName(), hobbitSam.getName())));
        manager.addItem(hobbitSam, new Item("Staff", 10), (item) -> System.out.println(String
                .format("%s был добавлен в инвентарь к %s.", item.getName(), hobbitSam.getName())));
        manager.addItem(hobbitSam, new Item("Food", 500), (item) -> System.out.println(String
                .format("%s был добавлен в инвентарь к %s.", item.getName(), hobbitSam.getName())));
    }
}
