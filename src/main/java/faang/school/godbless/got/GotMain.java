package faang.school.godbless.got;

import java.util.HashMap;
import java.util.Map;

public class GotMain {

    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        addNewHouse(houses, new House("Stark", "Wolf"));
        addNewHouse(houses, new House("Baratheon", "Stag"));
        addNewHouse(houses, new House("Lion", "Wolf"));
        addNewHouse(houses, new House("Targaryen", "Dragon"));
        addNewHouse(houses, new House("Mormont", "Bear"));
        printHouses(houses);
        removeHouse(houses, "Mormont");
        printHouses(houses);
        sigilInfo(houses, "Lion");
    }

    public static void addNewHouse(Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    public static void removeHouse(Map<String, House> map, String houseName) {
        map.remove(houseName);
    }

    public static void printHouses(Map<String, House> houses) {
        System.out.println(houses);
    }

    public static void sigilInfo(Map<String, House> map, String houseName) {
        System.out.println(map.get(houseName).getSigil());
    }
}
