package hashmap.got;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static final Map<String, House> HOUSES_MAP = new HashMap<>();
    public static void main(String[] args) {
        House stark = new House("Stark", "Direwolf");
        House lannister = new House("Lannister", "Lion");
        House baratheon = new House("Baratheon", "Deer");
        addToMap(stark);
        addToMap(lannister);
        addToMap(baratheon);
        printAllHouses();
        searchingHouse("Baratheon");
        searchingHouse("Arryn");
        removeFromMap("Lannister");
        removeFromMap("Greyjoy");
        printAllHouses();
    }

    public static void addToMap(@NonNull House house) {
        if (HOUSES_MAP.containsKey(house.getName())) {
            System.out.println("House is already added");
        } else {
            HOUSES_MAP.put(house.getName(), house);
            System.out.println("House " + house.getName() + " is added");
        }
    }

    public static void removeFromMap(@NonNull String name) {
        if (!HOUSES_MAP.containsKey(name)) {
            System.out.println("Map doesn't contain this house");
        } else {
            HOUSES_MAP.remove(name);
            System.out.println("House remove from map");
        }
    }

    public static House searchingHouse(@NonNull String name) {
        House house = HOUSES_MAP.get(name);
        if (house == null) {
            System.out.println("Map doesn't contain this house");
        } else {
            System.out.println("The sigil of " + house.getName() + " house is " + house.getSigil());
        }

        return house;
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : HOUSES_MAP.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
