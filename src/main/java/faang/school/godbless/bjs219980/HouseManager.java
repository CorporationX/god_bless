package faang.school.godbless.bjs219980;

import java.util.Map;

public class HouseManager {
    public static void addHouse(Map<String, House> houses, String name, String sigil) {
        House newHouse = new House(name, sigil);
        houses.put(name, newHouse);
        System.out.println("House " + name + " added: " + houses);
    }

    public static void removeHouse(Map<String, House> houses, String name) {
        if (houses.containsKey(name)) {
            houses.remove(name);
            System.out.println("House " + name + " removed: " + houses);
        } else {
            System.out.println("House not found");
        }
    }

    public static void findSigilByHouseName(Map<String, House> houses, String name) {
        if (houses.containsKey(name)) {
            House house = houses.get(name);
            System.out.println("Sigil of the " + house.getName() + " house: " + house.getSigil());
        } else {
            System.out.println("House not found");
        }
    }

    public static void findAll(Map<String, House> houses) {
        for (House house : houses.values()) {
            System.out.println("Name: " + house.getName() + ", Sigil: " + house.getSigil());

        }
    }
}
