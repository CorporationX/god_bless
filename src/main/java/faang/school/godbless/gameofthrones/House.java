package faang.school.godbless.gameofthrones;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class House {
    private String name;
    private String sigil;

    private static Map<String, House> houses = new HashMap<>();

    public House(String name, String sigil) {
        this.name = name;
        this.sigil  = sigil;
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
        System.out.println("House added: " + house);
    }

    public static void deleteHouse(String houseName) {
        House removedHouse = houses.remove(houseName);
        if (removedHouse != null) {
            System.out.println("House removed: " + removedHouse);
        } else {
            System.out.println("House not found: " + houseName);
        }
    }

    public static void findHouse(String houseName) {
        if (houses.containsKey(houseName)) {
            System.out.println(houses.get(houseName).getSigil());
        } else {
            System.out.println("House not found: " + houseName);
        }
    }

    public static void listAllHouses() {
        if (houses.isEmpty()) {
            System.out.println("No houses found");
        } else {
            for (House house : houses.values()) {
                System.out.println(house);
            }
        }
    }
}
