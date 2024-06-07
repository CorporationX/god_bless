package faang.school.godbless;

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

        removeHouse("Lanister");
        searchHouse("Barateon");
        printHouses();
    }

    public static void removeHouse(String name) {
        houses.remove(name);
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void searchHouse(String name) {
        System.out.println(houses.get(name).getSigil());
    }

    public static void printHouses() {
        for (Map.Entry<String, House> house : houses.entrySet()) {
            System.out.println("|" + house.getKey() + "|  |" + house.getValue().getSigil() + "|");
        }
    }
}
