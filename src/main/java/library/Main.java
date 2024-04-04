package library;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "sigil1"));
        houses.put("Lannister", new House("Lannister", "sigil2"));
        houses.put("Baratheon", new House("Baratheon", "sigil3"));

        addToHouses(houses, new House("Qwerty", "sigil4"));
        printAllHouses(houses);
        System.out.println();

        deleteFromHouses(houses, "Qwerty");
        printAllHouses(houses);
        System.out.println();

        findHouse(houses, "Qwerty");
        findHouse(houses, "Stark");
    }

    public static void addToHouses(Map<String, House> arg, House h1) {
        arg.put(h1.name(), h1);
    }

    public static void deleteFromHouses(Map<String, House> arg, String name) {
        arg.remove(name);
    }

    public static void findHouse(Map<String, House> arg, String name) {
        if (arg.containsKey(name)) {
            System.out.println(arg.get(name).sigil());
        } else {
            System.out.println("There is no such house on the list.");
        }
    }

    public static void printAllHouses(Map<String, House> arg) {
        for (Map.Entry<String, House> entry : arg.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", house: " +
                    entry.getValue().sigil());
        }
    }
}
