package bjs2_29012;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses;

    public static void main(String[] args) {
        houses = new HashMap<>() {{
            put("Stark", new House("Stark", "Owl"));
            put("Lannister", new House("Lannister", "Deer"));
            put("Barateon", new House("Barateon", "Bear"));
        }};

        addNewHouse(new House("Some house", "Camel"));
        printHouseSigil("Stark");
        System.out.println();

        removeHouse("Stark");
        printHouseSigil("Stark");
        System.out.println();

        printAllHouses();
    }

    public static void addNewHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(String houseName) {
        if (houses.containsKey(houseName)) {
            houses.remove(houseName);
        } else {
            System.out.println("House does not exist");
        }
    }

    public static void printHouseSigil(String houseName) {
        if (houses.containsKey(houseName)) {
            System.out.println(houses.get(houseName).getSigil());
        } else {
            System.out.println("House does not exist");
        }
    }

    public static void printAllHouses() {
        for (House house : houses.values()) {
            System.out.println(house);
        }
    }
}
