package school.faang.GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "Grey Wolf");
        House lannister = new House("Lannister", "Golden Lion");
        addHouse(stark);
        addHouse(lannister);
        addHouse("Baratheon", "Black Stag");

        printHouses();
        System.out.println();

        removeHouseByName("Lannister");
        printHouses();
        System.out.println();

        printSigilByName("Stark");
    }

    public static void addHouse(House house) {
        HOUSES.put(house.getName(), house);
    }

    public static void addHouse(String name, String sigil) {
        HOUSES.put(name, new House(name, sigil));
    }

    public static void removeHouseByName(String name) {
        HOUSES.remove(name);
    }

    public static House printSigilByName(String name) {
        System.out.println(HOUSES.get(name).getSigil());
        return HOUSES.get(name);
    }

    public static void printHouses() {
        HOUSES.forEach((name, house) -> {System.out.println(house);});
    }
}
