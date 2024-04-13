package faang.school.godbless.BJS2_5368;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houseMap = new HashMap<>();

    static {
        houseMap.put("Lannister", new House("Lannister", "Wolf"));
        houseMap.put("Targaryen", new House("Targaryen", "Three-headed Dragon"));
        houseMap.put("Baratheon", new House("Baratheon", "Stag"));
        houseMap.put("Greyjoy", new House("Greyjoy", "Kraken"));
    }

    public static void addHouse(House house) {
        if (houseMap.containsKey(house.getName())) {
            throw new IllegalArgumentException("House" + house.getName() + "alredy added");
        }
        houseMap.put(house.getName(), house);
    }

    public static void deleteHouse(String houseName) {
        houseMap.remove(houseName);
    }

    public static void printHouseInfo(String houseName) {
        if (!houseMap.containsKey(houseName)) {
            throw new IllegalArgumentException("House " + houseName + " not found");
        }
        System.out.println((houseMap.get(houseName).getSigil()));
    }

    public static void printAllHouseInfo() {
        houseMap.values().forEach(house -> System.out.println(house.getName() + " " + house.getSigil()));
    }
}
