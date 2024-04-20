package faang.school.godbless.got;

import java.util.HashMap;
import java.util.Map;

public class GotMain {

    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        addNewHouse(houses, new House("Stark", "Wolf"));
        addNewHouse(houses, new House("Baratheon", "Stag"));
        addNewHouse(houses, new House("Lannister", "Lion"));
        addNewHouse(houses, new House("Targaryen", "Dragon"));
        addNewHouse(houses, new House("Mormont", "Bear"));
        printHouses(houses);
        removeHouse(houses, "Mormont");
        printHouses(houses);
        printSigilInfo(houses, "Stark");
        addNewHouse(houses, new House("Alliance", "Lion"));
        printHouses(houses);
    }

    public static void addNewHouse(Map<String, House> houses, House house) {
        if (!(house.getName() == null || house.getName().isEmpty())) houses.put(house.getName(), house);
        else throw new IllegalArgumentException("House name is empty");
    }

    public static void removeHouse(Map<String, House> houses, String houseName) {
        if (!(houseName == null || houseName.isEmpty())) houses.remove(houseName);
        else throw new IllegalArgumentException("House name is empty");
    }

    public static void printHouses(Map<String, House> houses) {
        System.out.println(houses);
    }

    public static void printSigilInfo(Map<String, House> houses, String houseName) {
        System.out.println(houses.get(houseName).getSigil());
    }
}
