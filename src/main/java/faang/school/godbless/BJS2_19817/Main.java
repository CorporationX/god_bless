package faang.school.godbless.BJS2_19817;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        houses.put("Stark", new House("Stark", "stark sigil"));
        houses.put("Lanister", new House("Lanister", "lanister sigil"));
        houses.put("Baratheon", new House("Baratheon", "baratheon sigil"));

        addHouse();
        deleteHouseByName("Stark");
        System.out.println(findSigilByHouse("Baratheon"));
        printHouses();
    }

    public static void addHouse(){
        houses.put("Targaryen", new House("Targaryen", "targaryen sigil"));
    }

    public static void deleteHouseByName(String name){
        houses.remove(name);
    }

    public static String findSigilByHouse(String name){
        return houses.get(name).getSigil();
    }

    public static void printHouses(){
        houses.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
