package GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Targaryen", new House("Targaryen", "Dragon"));
        houses.put("Baratheon", new House("Baratheon", "Reindeer"));

        Main.addHouse(new House("NewHouse", "NewSigil"));

        Main.removeHouse("Lannister");

        System.out.println(Main.getSigil("Stark"));
        System.out.println(Main.getSigil("Park"));

        Main.seeAllHouses();
    }

    private static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    private static void removeHouse(String houseName) {
        houses.remove(houseName);
    }

    private static String getSigil(String houseName) {
        String foundSigil = "";
        try {
            foundSigil = houses.get(houseName).getSigil();
        } catch (NullPointerException exception) {
            System.out.println("House " + houseName + " not found!");
        }
        return foundSigil;
    }

    private static void seeAllHouses() {
        houses.forEach((k, v) -> {
            System.out.println(k + " " + v);
        });
    }
}
