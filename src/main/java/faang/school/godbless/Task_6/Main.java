package faang.school.godbless.Task_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, House> houses = new HashMap<>();

        houses.put("Stark", new House("Stark", "Stark sigil"));
        houses.put("Lanister", new House("Lanister", "Lanister sigil"));

        House house = new House("Barateon", "Barateon sigil");

        addNewHouse(houses, house);

        removeHouseByName(houses, "Barateon");

        searchHouseByName(houses, "Lanister");

        allHousesAndSigis(houses);

    }

    static Map<String, House> addNewHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
        return houses;
    }

    static void removeHouseByName(Map<String, House> houses, String houseName) {
        if (houses.containsKey(houseName)) {
            houses.remove(houseName);
        } else {
            System.out.println("There is no such house");
        }
    }

    static void searchHouseByName(Map<String, House> houses, String houseName) {
        if (houses.get(houseName) != null) {
            House house1 = houses.get(houseName);
            System.out.println(house1.getSigil());
        } else System.out.println("There is no such house");
    }

    static void allHousesAndSigis(Map<String, House> houses) {
        System.out.println(houses.values().stream().toList());
    }
}
