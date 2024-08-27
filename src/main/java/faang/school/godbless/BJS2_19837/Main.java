package faang.school.godbless.BJS2_19837;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    private  static final Map<String , House> houses = new HashMap<>();
    public static void main(String[] args) {
        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Lion"));
        addHouse(new House("Baratheon", "Stag"));
        addHouse(new House("Targaryen", "Dragon"));

        printAllHouses();
        System.out.println();

        printHouseInfo("Stark");
        System.out.println();

        removeHouse("Baratheon");
        printAllHouses();
        System.out.println();

        addHouse(new House("Greyjoy", "Kraken"));
        printAllHouses();
    }
    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }
    public static void removeHouse(String name) {
        houses.remove(name);
    }
    public static void printHouseInfo(String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("House " + name + " not found.");
        }
    }
    public static void printAllHouses() {
        if (houses.isEmpty()) {
            System.out.println("No houses found.");
        } else {
            for (House house : houses.values()) {
                System.out.println(house);
            }
        }
    }

}
