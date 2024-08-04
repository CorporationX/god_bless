package faang.school.godbless.gameofthrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        houses.put("Stark", new House("Stark", "Direwolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Stag"));

        System.out.println("Adding House 'Targaryen'...");
        addHouse("Targaryen", "Dragon");

        System.out.println("\nAll Houses and their sigils:");
        printAllHouses();

        System.out.println("\nRemoving House 'Lannister'...");
        removeHouse("Lannister");

        System.out.println("\nAll Houses after removing 'Lannister':");
        printAllHouses();

        System.out.println("\nFinding House by name 'Stark' and outputting its sigil...");
        System.out.println("\nThe House 'Stark' sigil is: " + findSigilByName("Stark"));
    }

    public static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public static void removeHouse(String name) {
        houses.remove(name);
    }

    public static String findSigilByName(String name) {
        return houses.get(name).getSigil();
    }

    public static void printAllHouses() {
        for (House house : houses.values()) {
            System.out.println(house);
        }
    }
}
