package faang.school.godbless.BJS2_8093;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houseSigils = new HashMap<>();
        houseSigils.put("Stark", new House("Stark", "Grey direwolf"));
        houseSigils.put("Lannister", new House("Lannister", "Golden lion"));
        houseSigils.put("Baratheon", new House("Baratheon", "Crowned stag"));
        printAllHouses(houseSigils);
        removeHouse(houseSigils, "Lannister");
        System.out.println();
        printAllHouses(houseSigils);
        addHouse(houseSigils, new House("Lannister", "Golden lion"));
        System.out.println();
        printHouseSigil(houseSigils, "Lannister");
    }

    public static void addHouse(Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    public static void removeHouse(Map<String, House> map, String houseName) {
        map.remove(houseName);
    }

    public static void printHouseSigil(Map<String, House> map, String houseName) {
        System.out.println(map.get(houseName));
    }

    public static void printAllHouses(Map<String, House> map) {
        map.forEach((s, house) -> System.out.println(house));
    }
}
