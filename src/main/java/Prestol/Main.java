package Prestol;

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

        printHouse(houses, "Qwerty");
        printHouse(houses, "Stark");
    }

    private static void addToHouses(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    private static void deleteFromHouses(Map<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    private static void printHouse(Map<String, House> houses, String houseName) {
        if (houses.containsKey(houseName)) {
            System.out.println(houses.get(houseName).getSigil());
        } else {
            System.out.println("There is no such house on the list.");
        }
    }

    private static void printAllHouses(Map<String, House> houses) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", house: " +
                    entry.getValue().getSigil());
        }
    }
}
