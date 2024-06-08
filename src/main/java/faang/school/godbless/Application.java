package faang.school.godbless;

import faang.school.godbless.task6.House;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }
    public static void removeHouse(Map<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    public static void searchHouse(Map<String, House> houses, String houseName) {
        House result = houses.get(houseName);
        if (result == null) {
            System.out.println("There is no such house");
        } else {
            System.out.println("House name: " + result.getName() + " house sigil: " + result.getSigil());
        }
    }

    public static void printHouses(Map<String, House> houses) {
        for (Map.Entry<String, House> entry: houses.entrySet()) {
            System.out.println("House name: " + entry.getKey() + " house: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        House stark = new House("Stark", "wolf");
        House lannister = new House("Lannister", "lion");
        House barateon = new House("Barateon", "deer");
        addHouse(houses, stark);
        addHouse(houses, lannister);
        addHouse(houses, barateon);
        removeHouse(houses, "Lannister");
        searchHouse(houses, "Stark");
        printHouses(houses);
    }
}