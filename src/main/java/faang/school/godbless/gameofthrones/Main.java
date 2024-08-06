package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Deer"));

        showHousesInfo(houses);
        System.out.println();

        addHouse(houses, new House("Targarien", "Dragon"));

        showHousesInfo(houses);
        System.out.println();

        removeHouse(houses, "Lannister");
        removeHouse(houses, "Baratheon");

        showHousesInfo(houses);
        System.out.println();

        showSigilByHouseName(houses, "Stark");
        showSigilByHouseName(houses, "Targarien");
    }

    private static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    private static void removeHouse(Map<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    private static void showSigilByHouseName(Map<String, House> houses, String houseName) {
        System.out.println(houses.get(houseName).getSigil());
    }

    private static void showHousesInfo(Map<String, House> houses) {
        houses.forEach((key, value) -> System.out.println("Name: " + key + ", Sigil: " + value.getSigil()));
    }
}
