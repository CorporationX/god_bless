package faang.school.godbless.JavaHashMap.BJS2_8051;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

import static faang.school.godbless.JavaHashMap.BJS2_8051.House.*;
import static faang.school.godbless.JavaHashMap.BJS2_8051.Main.houses;

public class Main {
    static Map<String, House> houses = new HashMap<>();
    public static void main(String[] args) {
        houses.put("Stark", new House("Stark", "Direwolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Baratheon", new House("Baratheon", "Stag"));
        houses.put("Targaryen", new House("Targaryen", "Dragon"));
        addHouse("Greyjoy", "Kraken");
        removeHouse("Baratheon");
        removeHouse("Biba");
        printHouse("Stark");
        printHouse("Aboba");
        printAllHouses();
    }
}
@AllArgsConstructor
@Data
class House{
    private String houseName;
    private String houseSigil;
    public static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
        System.out.println("House added: " + name);
    }
    public static void removeHouse(String name) {
        if (houses.containsKey(name)) {
            houses.remove(name);
            System.out.println("House removed: " + name);
        } else {
            System.out.println("House not found: " + name);
        }
    }
    public static void printHouse(String name) {
        House house = houses.get(name);
        if (house != null) {
            System.out.println("House found: " + house);
        } else {
            System.out.println("House not found: " + name);
        }
    }
    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
