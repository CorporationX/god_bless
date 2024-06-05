package BJS2_8021;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        addHouse("Stark", "Direwolf");
        addHouse("Lannister", "Lion");
        addHouse("Baratheon", "Stag");
        addHouse("Targaryen", "Dragon");

        printAllHouses();

        removeHouse("Baratheon");

        printAllHouses();

        System.out.println(findHouse("Targaryen"));
        System.out.println(findHouse("ABOBA"));
    }

    public static void addHouse(String nameHouse, String sigil) {
        houses.put(nameHouse, new House(nameHouse, sigil));
    }

    public static void removeHouse(String nameHouse) {
        houses.remove(nameHouse);
    }

    public static String findHouse(String nameHouse) {
        House house = houses.get(nameHouse);
        return house != null ? house.getSigil() : null;
    }

    public static void printAllHouses() {
        houses.forEach((key, value) -> {
            System.out.println("House: " + key + "sigil: " + value.getSigil());
        });
    }
}