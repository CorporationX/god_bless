package gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>();


    public static void main(String[] args) {

        printAllHouses();

        HOUSES.computeIfAbsent("Stark", key -> new House("Stark", "SOW"));
        HOUSES.computeIfAbsent("Lannister", key -> new House("Lannister", "LOCR"));
        HOUSES.computeIfAbsent("Barateon", key -> new House("Barateon", "BOSE"));
        printAllHouses();

        addHouse("Targaryen", "TOKL");
        addHouse("Arryn", "Arr");
        addHouse("Tully", "TOR");
        addHouse("Greyjoy", "GOP");
        addHouse("Tyrell", "TOH");
        addHouse("Martell", "MOS");

        System.out.println();
        printAllHouses();

        removeHouse("Targaryen");
        removeHouse("Arryn");
        removeHouse("Tully");
        System.out.println();
        printAllHouses();


        System.out.println();
        System.out.println("Greyjoy: " + findHouse("Greyjoy"));
        System.out.println("Tyrell: " + findHouse("Tyrell"));
        System.out.println("Targaryen: " + findHouse("Targaryen"));
    }

    public static void addHouse(String name, String sigil) {
        HOUSES.computeIfAbsent(name, (k) -> new House(name, sigil));
    }

    public static void removeHouse(String name) {
        HOUSES.remove(name);
    }

    public static String findHouse(String name) {
        if (HOUSES.containsKey(name)) {
            return HOUSES.get(name).getSigil();
        } else {
            return null;
        }
    }

    public static void printAllHouses() {
        HOUSES.forEach((key, house) -> System.out.println("Дом-" + house.getName() + ". Герб-" + house.getSigil()));
    }


}
