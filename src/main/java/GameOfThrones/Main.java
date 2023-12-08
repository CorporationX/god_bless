package GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();

        houses.put("Stark", new House("Stark", "Sigil of Stark"));
        houses.put("Lannister", new House("Lannister", "Sigil of Lannister"));
        houses.put("Barateon", new House("Barateon", "Sigil of Barateon"));

        System.out.println("Inicial map: " + houses.toString());
        addHouse(houses, "New House", "New Sigil");
        System.out.println("After add new House: " + houses.toString());
        removeHouse(houses, "New House");
        System.out.println("After remove new House: " + houses.toString());
        printSigil(houses, "Stark");
        System.out.println("List of Houses: ");
        getListHouses(houses);
    }

    public static void addHouse(Map<String, House> houseMap, String houseName, String houseSigil) {
        houseMap.put(houseName, new House(houseName, houseSigil));
    }

    public static void removeHouse(Map<String, House> houseMap, String houseName) {
        houseMap.remove(houseName);
    }

    public static void printSigil(Map<String, House> houseMap, String houseName) {
        System.out.println("Sigil of " + houseName + " is: " + houseMap.get(houseName).getSigil());
    }

    public static void getListHouses(Map<String, House> houseMap) {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}