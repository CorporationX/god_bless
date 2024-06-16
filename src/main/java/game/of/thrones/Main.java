package game.of.thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouse("Таргариен", "Трехглавый дракон");
        addHouse("Старк", "Волк");
        addHouse("Баратеон", "Олень");
        addHouse("Ланнистер", "Лев");

        AllHouses();
        findHouse("Старк");
        removeHouse("Баратеон");
    }

    private static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    private static void removeHouse(String name) {
        houses.remove(name);
    }

    private static void findHouse(String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println(house.getSigil());
        } else {
            System.out.println("House not found.");
        }
    }

    private static void AllHouses() {
        for (House house : houses.values()) {
            System.out.println(house);
        }
    }
}

