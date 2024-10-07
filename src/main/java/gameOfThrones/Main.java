package gameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<String, House> HOUSES = new HashMap<>();

    public static void addHouse(String name, String sigil) {
        HOUSES.put(name, new House(name, sigil));
    }

    public static void removeHouse(String name) {
        HOUSES.remove(name);
    }

    public static void getHouse(String name) {
        System.out.println(HOUSES.get(name));
    }

    public static void printHouses() {
        HOUSES.forEach((k, v) -> System.out.println(v));
    }

    public static void main(String[] args) {
        addHouse("Stark", "Winter is Coming");
        printHouses();
        System.out.println();

        addHouse("Targaryen", "Fire and Blood");
        addHouse("Baratheon", "Oath of Strom");
        printHouses();
        System.out.println();

        removeHouse("Targaryen");
        printHouses();
        System.out.println();

        getHouse("Targaryen");
        getHouse("Stark");
        getHouse("Baratheon");
    }
}
