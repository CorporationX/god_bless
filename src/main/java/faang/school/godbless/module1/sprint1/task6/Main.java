package faang.school.godbless.module1.sprint1.task6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, House> HOUSES_OF_WESTEROS = new HashMap<>();

    public static void main(String[] args) {
        HOUSES_OF_WESTEROS.put("Tyrell", new House("Tyrell", "Lily"));
        HOUSES_OF_WESTEROS.put("Stark", new House("Stark", "Wolf"));
        HOUSES_OF_WESTEROS.put("Frey", new House("Frey", "Two Towers"));
        House house = new House("Bolton", "Ragged Man");

        printHouses();
        printSigil("Stark");
        addHouse(house);
        deleteHouse("Frey");

    }

    public static void printHouses() {
        for (Map.Entry<String, House> entry : HOUSES_OF_WESTEROS.entrySet()) {
            System.out.println(entry.getValue().getName() + " " + entry.getValue().getSigil());
        }
    }

    public static void printSigil(String name) {
        for (House entry : HOUSES_OF_WESTEROS.values()) {
            if (entry.getName().equals(name)) {
                System.out.println(entry.getSigil());
            }
        }
    }

    public static void addHouse(House house) {
        HOUSES_OF_WESTEROS.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        HOUSES_OF_WESTEROS.remove(name);
    }
}
