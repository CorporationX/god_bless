package faang.school.godbless.vesteros;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houses = new HashMap<>();
    public static void main(String[] args) {

        addHouse("Lion", new House("Lannister", "Lion"));
        addHouse("Wolf", new House("Stark", "Wolf"));
        addHouse("Stag", new House("Barateon", "Stag"));
        printAll();
        deleteHouse("Lion");
        findHouse("Wolf");
        printAll();



    }

    public static void addHouse(String name, House house) {
        houses.put(name, new House(house.getName(), house.getSigil()));
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static void findHouse(String name) {
        System.out.println(houses.get(name).getSigil());
    }

    public static void printAll() {
        for (House house: houses.values()) {
            System.out.println(house.getName() + " " + house.getSigil());
        }
    }
}
