package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Map<String, House> houses = new HashMap<>();
        houses.put("House Stark", new House("Stark", "Wolf"));
        houses.put("House Tully", new House("Tully", "Fish"));
        houses.put("House Targaryen", new House("Targaryen", "Dragon"));


        addNewHouse(houses, "Lannister", "Lion");
        addNewHouse(houses, "", "");
        printAllHouses(houses);

        System.out.println("_________________________________");

        deleteHouse(houses, "House Tully");
        printAllHouses(houses);

        System.out.println("_________________________________");

        printHouseByName(houses, "House Targaryen");
    }

    private static void addNewHouse(Map<String, House> houses, String name, String sigil) {
        if (name == null || sigil == null) {
            throw new NullPointerException("Exception: name or sigil is null!");
        }
        if (name.isEmpty() || sigil.isEmpty()) {
            System.out.println("name or sigil is empty!");
            return;
        }

        if (!houses.containsKey("House " + name)) {
            houses.put("House " + name, new House(name, sigil));
        } else {
            System.out.println("Such a house is already on the list!");
        }

    }

    private static void deleteHouse(Map<String, House> houses, String name) {
        houses.remove(name);
    }

    private static void printAllHouses(Map<String, House> houses) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println("House: " + entry.getValue().getName() + " | " + "Sigil: " + entry.getValue().getSigil());
        }
    }

    private static void printHouseByName(Map<String, House> houses, String name) {
        try {
            System.out.println("House " + houses.get(name).getName() + " | " + "House Sigil: " + houses.get(name).getSigil());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}