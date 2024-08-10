package faang.school.godbless;

import java.util.HashMap;

public class Main {
    private static final HashMap<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Lion"));
        addHouse(new House("Baratheon", "Stag"));
        addHouse(new House("Targaryen", "Three-headed dragon"));

        System.out.println("All houses:");
        listAllHouses();

        System.out.println("Search for House Stark:");
        searchHouse("Stark");

        System.out.println("Search for House Unknown:");
        searchHouse("Unknown");

        System.out.println("Removing House Lannister:");
        removeHouse("Lannister");

        System.out.println("All houses after removal:");
        listAllHouses();

        System.out.println("Adding a new house Greyjoy:");
        addHouse(new House("Greyjoy", "Kraken"));

        System.out.println("All houses after adding Greyjoy:");
        listAllHouses();

    }
    public static void addHouse(House house) {
        if (house != null) {
            houses.put(house.getName(), house);
            System.out.println("House added: \n    " + house);
        } else {
            throw new IllegalArgumentException("    House cannot be null");
        }
    }

    public static void removeHouse(String name) {
        House removedHouse = houses.remove(name);

        if (removedHouse != null) {
            System.out.println("    House removed: " + removedHouse);
        } else {
            System.out.println("    House not found.");
        }
    }

    public static void searchHouse(String name) {
        House house = houses.get(name);

        if (house != null) {
            System.out.println("    " + house);
        } else {
            System.out.println("    House not found.");
        }
    }

    public static void listAllHouses() {
        if (houses.isEmpty()) {
            System.out.println("    No houses available.");
        } else {
            houses.forEach((name, house) -> System.out.println("    " + house));
        }
    }
}