package faang.school.godbless.BJS2_19898;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, House> houses = new HashMap<String, House>();

    public static void main(String[] args) {
        addHouse("Stark", "A grey direwolf on a white field");
        addHouse("Lannister", "A golden lion on a crimson field");
        addHouse("Baratheon", "A crowned black stag on a golden field");

        printAllHouses();

        findHouse("Stark");

        removeHouse("Lannister");

        printAllHouses();
    }

    private static void addHouse(String houseName, String sigil) {
        houses.put(houseName, new House(houseName, sigil));
    }

    public static void removeHouse(String name) {
        if (houses.containsKey(name)) {
            houses.remove(name);
            System.out.println("Removed house: " + name);
        } else {
            System.out.println("House not found: " + name);
        }
    }

    public static void findHouse(String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println("Found: " + house);
        } else {
            System.out.println("House not found: " + name);
        }
    }

    public static void printAllHouses() {
        if (houses.isEmpty()) {
            System.out.println("No houses found.");
        } else {
            System.out.println("Listing all houses:");
            for (House house : houses.values()) {
                System.out.println(house);
            }
        }
    }

}
