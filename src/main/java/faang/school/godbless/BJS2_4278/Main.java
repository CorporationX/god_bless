package faang.school.godbless.BJS2_4278;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addNewHouse("Stark", new House("Stark", "Stark-flag"));
        addNewHouse("Baratheon", new House("Baratheon", "Baratheon-flag"));
        addNewHouse("Lannister", new House("Lannister", "Lannister-flag"));
        addNewHouse("Tyrell", new House("Tyrell", "Tyrell-flag"));

        removeHouse("Tyrell");

        printInfoHouse("Baratheon");

        printAllHouses();
    }

    private static void addNewHouse(String houseName, House house) {
        houses.putIfAbsent(houseName, house);
    }

    private static void removeHouse(String houseName) {
        houses.remove(houseName);
    }

    private static void printInfoHouse(String name) {
        System.out.println(houses.get(name));
    }

    private static void printAllHouses() {
        for (var entry : houses.entrySet()) {
            System.out.println("House name: " + entry.getKey());
            System.out.println("House info: " + entry.getValue());
        }
    }
}
