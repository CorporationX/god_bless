package faang.school.godbless.gameOfThrones;

import java.util.HashMap;

public class Main {
    private static HashMap<String, House> houses = new HashMap<>();

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String houseName) {
        houses.remove(houseName);
    }

    public static House findHouse(String houseName) {
        return houses.get(houseName);
    }

    public static void printHouseInfo(String houseName) {
        House house = houses.get(houseName);
        System.out.println(house);
    }

    public static void printAllHousesInfo() {
        for (House house : houses.values()) {
            System.out.println(house);
        }
    }

    public static void main(String[] args) {
        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Golden lion"));
        addHouse(new House("Baratheon", "Black deer with a crown"));
        addHouse(new House("Mormont", "Black bear"));
        addHouse(new House("Bolton", "Flayed man"));
        addHouse(new House("Targaryen", "Red three-headed dragon"));
        addHouse(new House("Tyrell", "Golden rose"));
        addHouse(new House("Tully", "Silver trout"));
        addHouse(new House("Arryn", "White flying falcon"));
        addHouse(new House("Martell", "Red sun pierced by a golden spear"));

        deleteHouse("Bolton");

        System.out.println(findHouse("Stark"));

        printHouseInfo("Tyrell");

        System.out.println("Houses of Westeros:");
        printAllHousesInfo();
    }
}
