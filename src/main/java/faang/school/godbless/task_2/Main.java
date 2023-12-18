package faang.school.godbless.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {

        houseMap.put("Stark", new House("Stark", "Wolf"));
        houseMap.put("Lannister", new House("Lannister", "Leo"));
        houseMap.put("Barateon", new House("Barateon", "Deer"));

        addHouse("Stark", new House("Stark", "Wolf"));

        removeHouse("Lannister");

        searchHouse("Stark");

        searchHouse("Lannister");

        getHousesAndSigils();
    }

    static void addHouse(String name, House house) {
        houseMap.put(name, house);
    }

    static void removeHouse(String name) {
        houseMap.remove(name);
    }

    static void searchHouse(String name) {
        if (houseMap.containsKey(name)) {
            System.out.println("Found - " + houseMap.get(name).getName() + " sigil is: " + houseMap.get(name).getSigil() + '\n');
        } else {
            System.out.println("Map not contains this house!\n");
        }
    }

    static void getHousesAndSigils() {
        houseMap.forEach((key, value) -> System.out.println(key + ":" + value + '\n'));
    }
}
