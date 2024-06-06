package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, House> houses = new HashMap<>();

        House stark = new House("Stark", "Голова серого лютоволка на бело-зелёном фоне");
        House lannister = new House("Lannister", "Золотой лев, стоящий на задних лапах, на малиновом поле");
        House barateon = new House("Barateon", "Чёрный коронованный олень, стоящий на задних ногах, на золотом поле");

        addHouse(houses, stark);

        allHousesListing(addHouse(houses, lannister));

        addHouse(houses, barateon);

        searchHouseAndListingSigil(houses, "Barateon");

        allHousesListing(houses);

        allHousesListing(deleteHouse(houses, "Lannister"));

    }

    public static Map<String, House> addHouse(Map<String, House> houses, House house) {
        if (houses != null && house != null) {
            houses.put(house.getName(), house);
            return houses;
        } else return Map.of();
    }

    public static Map<String, House> deleteHouse(Map<String, House> houses, String houseName) {
        if (houses != null && houseName != null) {
            houses.remove(houseName);
            return houses;
        } else return Map.of();
    }

    public static void searchHouseAndListingSigil(Map<String, House> houses, String houseName) {
        if (houses != null && houseName != null) {
            String listingSigil = houses.get(houseName).getSigil();
            System.out.println("Information about sigil of " + houseName + ": " + listingSigil);
        }
    }

    public static void allHousesListing(Map<String, House> houses) {
        if (houses != null) {
            for (Map.Entry<String, House> entry : houses.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getSigil());
            }
        }
    }
}
