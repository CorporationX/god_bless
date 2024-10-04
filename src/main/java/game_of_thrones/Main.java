package game_of_thrones;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        houses.put("Stark", new House("Stark", "lannister sigil"));
        houses.put("Targaryen", new House("Targaryen", "targaryen sigil"));
        houses.put("Baratheon", new House("Baratheon", "baratheon sigil"));

        addHouse(new House("Tyrell", "tyrell sigil"));

        System.out.println(houses);

        removeHouseByName("Tyrell");

        System.out.println(houses);

        searchAndPrintHouseByName("Targaryen");

        printAllData();
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouseByName(String name) {
        houses.remove(name);
    }

    public static void searchAndPrintHouseByName(String name) {
        House house = houses.get(name);
        System.out.println("House: " + house.getName() + ", Sigil: " + house.getSigil());
    }

    public static void printAllData() {
        houses.forEach((name, house) -> System.out.println("House: " + house.getName() + ", Sigil: " + house.getSigil()));
    }
}
