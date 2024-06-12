package faang.school.godbless.GameOfThrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "Winter Is Coming");
        House lanister = new House("Lanister", "Hear Me Roar!");
        House barateon = new House("Barateon", "Ours Is The Fury");

        addHouse(stark);
        addHouse(lanister);
        addHouse(barateon);

        removeHouse("Lanster");
        removeHouse("Lanister");
        searchHouse("Barateon");
        printHouses();
    }

    public static void removeHouse(String name) {
        if (houses.containsKey(name)) {
            houses.remove(name);
        } else {
            System.out.println("There is no " + name);
        }
    }

    public static void addHouse(House house) {
        if (!houses.containsValue(house)) {
            houses.put(house.getName(), house);
        } else {
            System.out.println("House " + house + " is already exists");
        }
    }

    public static void searchHouse(String name) {
        if (houses.containsKey(name)) {
            System.out.println(houses.get(name).getSigil());
        } else {
            System.out.println("There is no " + name);
        }
    }

    public static void printHouses() {
        for (Map.Entry<String, House> house : houses.entrySet()) {
            System.out.println("|" + house.getKey() + "|  |" + house.getValue().getSigil() + "|");
        }
    }
}
