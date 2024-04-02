package faang.school.godbless.bjs2_4240;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Deer"));

        //show all houses with sigils
        showHousesSigils(houses);

        //show sigil by house name
        showSigilByHouseName(houses, "Stark");

        //add new House
        addHouse(houses, new House("Targarien", "Dragon"));
        showHousesSigils(houses);

        //remove House
        removeHouse(houses, "Stark");
        showHousesSigils(houses);

        //remove not existed house
        removeHouse(houses, "Apple");
    }


    public static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(Map<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    public static void showSigilByHouseName(Map<String, House> houses, String houseName) {
        System.out.println(houses.get(houseName).getSigil());
    }

    public static void showHousesSigils(Map<String, House> houses) {
        for (Map.Entry<String, House> houseEntry : houses.entrySet()) {
            System.out.println("Name: " + houseEntry.getKey() + ", Sigil: " + houseEntry.getValue().getSigil());
        }
    }
}
