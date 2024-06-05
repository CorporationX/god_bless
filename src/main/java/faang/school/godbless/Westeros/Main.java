package faang.school.godbless.Westeros;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void addNewHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(Map<String, House> houses, String nameHouse) {
        houses.remove(nameHouse);
    }

    public static void outputListHouses(Map<String, House> houses) {
        if (houses.isEmpty()) {
            System.out.println("There are no entries");
        } else houses.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static void searchByName(Map<String, House> houses, String nameHouse) {
        House house = houses.get(nameHouse);

        if (house != null) {
            System.out.println(house.getName() + ", sigil: " + house.getSigil());
        } else System.out.println("There is no such house");
    }

    public static void main(String[] args) {

        House baratheon = new House("Baratheon", "Black crowned stag");
        House stark = new House("Stark", "Gray direwolf head");
        House lannister = new House("Lannister", "Golden Lion");

        Map<String, House> houses = new HashMap<>();

        addNewHouse(houses, baratheon);
        addNewHouse(houses, stark);
        addNewHouse(houses, lannister);

        deleteHouse(houses, "Stark");

        searchByName(houses, "Baratheon");


        outputListHouses(houses);
    }
}
