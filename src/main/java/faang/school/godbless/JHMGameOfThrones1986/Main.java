package faang.school.godbless.JHMGameOfThrones1986;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> westerosHouses = new HashMap<>();
        addNewHouseToMap(westerosHouses, "Targaryen", "Three-headed Dragon");
        addNewHouseToMap(westerosHouses, "Stark", "Direwolf");
        addNewHouseToMap(westerosHouses, "Lannister", "Golden Lion");
        addNewHouseToMap(westerosHouses, "Greyjoy", "Kraken");
        removeHouseFromMap(westerosHouses, "Lannister");
        printSigilInfo(westerosHouses, "Targaryen");
        printAllHousesInfo(westerosHouses);
    }

    public static void addNewHouseToMap(Map<String, House> map, String name, String sigil) {
        map.put(name, new House(name, sigil));
    }

    public static void removeHouseFromMap(Map<String, House> map, String name) {
        if (map.containsKey(name)) {
            map.remove(name);
        } else {
            System.out.printf("%s's house is not present in Westeros%n", name);
        }
    }

    public static void printSigilInfo(Map<String, House> map, String name) {
        if (map.containsKey(name)) {
            System.out.printf("The sigil of %s's house is %s%n", name, map.get(name).getSigil());
        } else {
            System.out.printf("%s's house is not present in Westeros%n", name);
        }
    }

    public static void printAllHousesInfo(Map<String, House> map) {
        System.out.println("YOU CAN SEE ALL THE INFO ABOUT WESTEROS HOUSES BELOW");
        for (Map.Entry<String, House> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey())) {
                System.out.printf("House: %s - Sigil: %s\n", entry.getKey(), entry.getValue().getSigil());
            }
        }
    }
}
