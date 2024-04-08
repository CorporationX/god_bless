package faang.school.godbless.gameOfTheTrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> map = new HashMap<>();

    public static void main(String[] args) {

        House houseOfStark = new House("Stark", "Direwolf");
        House houseOfBaratheon = new House("Baratheon", "Stag");
        House houseOftLannister = new House("Lannister", "Lion");

        map.put("Stark", houseOfStark);
        map.put("Baratheon", houseOfBaratheon);
        map.put("Lannister", houseOftLannister);

        printAllHouses();
        removeAHouse("Stark");
        System.out.println("searchTheHouse: " + searchTheHouse("Baratheon"));
        addNewHouse("King", "Horse");
    }

    private static void removeAHouse(String name) {
        map.remove(name);
    }

    private static House searchTheHouse(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        return null;
    }

    private static void printAllHouses() {
        System.out.println("All Houses and Sigils:");
        for (House house : map.values()) {
            System.out.println(house);
        }
    }

    private static void addNewHouse(String name, String sigil) {
        House newHouse = new House(name, sigil);
        map.put(name, newHouse);
        System.out.println("You added new House: " + newHouse);
    }
}
