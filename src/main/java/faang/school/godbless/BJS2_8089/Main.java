package faang.school.godbless.BJS2_8089;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        addHouse("Stark", "Werewolf");
        addHouse("Baratheon", "Stag");
        addHouse("Targaryen", "Dragon");
        addHouse("Lannister", "Lion");

        printAllHousesInformation();

        removeHouse("Stark");

        printInformationAboutHouse("Stark");
    }

    public static void removeHouse(String name) {
        houses.remove(name);
    }

    public static void addHouse(String name, String emblem) {
        houses.put(name, new House(name, emblem));
    }

    public static void printInformationAboutHouse(String name) {
        House house = houses.get(name);

        if (house != null) {
            System.out.println("House: " + name + "\nSigil: " + house.getSigil());
        } else {
            System.out.println("Can't find house");
        }

    }

    public static void printAllHousesInformation() {
        for (var house : houses.entrySet()) {
            printInformationAboutHouse(house.getKey());
            System.out.println("-".repeat(20));
        }
    }
}
