package faang.school.godbless.gameOfTheTrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        run();

    }

    private static void run() {

        House houseOfStark = new House("Stark", "Direwolf");
        House houseOfBaratheon = new House("Baratheon", "Stag");
        House houseOftLannister = new House("Lannister", "Lion");

        Map<String, House> map = new HashMap<>();
        map.put("Stark", houseOfStark);
        map.put("Baratheon", houseOfBaratheon);
        map.put("Lannister", houseOftLannister);

        while (true) {
            menu();
            System.out.println("Enter number: ");
            int number = Util.getIntegerInput();
            if (number == 1) {
                printAllHouses(map);
            } else if (number == 2) {
                addNewHouse(map);
            } else if (number == 3) {
                searchTheHouse(map);
            } else if (number == 4) {
                removeAHouse(map);
            } else if (number == 5) {
                System.out.println("You are QUIT");
                break;
            } else {
                System.out.println("Unknown command! Try again!");
            }
        }
    }

    private static void menu() {
        System.out.println("***MENU***");
        System.out.println("1 - print all Houses and Sigils");
        System.out.println("2 - add new House");
        System.out.println("3 - search a House");
        System.out.println("4 - remove the House");
        System.out.println("5 - QUIT");
    }

    private static void removeAHouse(Map<String, House> map) {
        System.out.println("Enter name of remove: ");
        String name = Util.readLine();
        if (map.containsKey(name)) {
            System.out.println("The " + map.get(name) + " has been removed.");
            map.remove(name);
        } else {
            System.out.println("The House: " + name + " not found!");
        }
    }

    private static void searchTheHouse(Map<String, House> map) {
        System.out.println("Enter name of search: ");
        String houseName = Util.readLine();

        if (map.containsKey(houseName)) {
            System.out.println("The " + map.get(houseName) + " found.");
        } else {
            System.out.println("The House: " + houseName + " not found!");
        }
    }

    private static void printAllHouses(Map<String, House> map) {
        System.out.println("All Houses and Sigils from Game of the Trones:");
        for (House house : map.values()) {
            System.out.println(house);
        }
    }

    private static void addNewHouse(Map<String, House> map) {

        System.out.println("Enter new name: ");
        String name = Util.readLine();
        System.out.println("Enter new sigil: ");
        String sigil = Util.readLine();

        House newHouse = new House(name, sigil);
        map.put(name, newHouse);

        System.out.println("You added new House: " + newHouse);
    }
}
