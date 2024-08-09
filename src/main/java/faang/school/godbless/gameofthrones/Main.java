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
        addHouse(new House("Targaryen", "Dragon"));

        System.out.println("\nAll Houses and their sigils:");
        printAllHouses();

        System.out.println("\nRemoving House 'Lannister'...");
        removeHouse("Lannister");

        System.out.println("\nAll Houses after removing 'Lannister':");
        printAllHouses();

        System.out.println("\nFinding House by name 'Stark' and outputting its sigil...");
        System.out.println("The House 'Stark' sigil is: " + findSigilByName("Stark"));
        System.out.println("\nFinding House by name 'Hodor' and outputting its sigil...");
        System.out.println("The House 'Hodor' sigil is: " + findSigilByName("Hodor"));
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(String name) {
        houses.remove(name);
    }

    public static String findSigilByName(String name) {
        House house = houses.get(name);
        if (house != null) {
            return house.getSigil();
        } else {
            return "House '" + name + "' not found.";
        }
    }

    public static void printAllHouses() {
        for (House house : houses.values()) {
            System.out.println(house);
        }
    }
}
