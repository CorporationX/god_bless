package hashmap.got;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> housesMap = new HashMap<>();
        House stark = new House("Stark", "Direwolf");
        House lannister = new House("Lannister", "Lion");
        House baratheon = new House("Baratheon", "Deer");
        addToMap(housesMap, stark);
        addToMap(housesMap, lannister);
        addToMap(housesMap, baratheon);
        printAllHouses(housesMap);
        searchingHouse(housesMap, "Baratheon");
        searchingHouse(housesMap, "Arryn");
        removeFromMap(housesMap, "Lannister");
        removeFromMap(housesMap, "Greyjoy");
        printAllHouses(housesMap);
    }

    public static void addToMap(@NonNull Map<String, House> housesMap, @NonNull House house) {
        if (housesMap.containsKey(house.getName())) {
            System.out.println("House is already added");
        } else {
            housesMap.put(house.getName(), house);
            System.out.println("House " + house.getName() + " is added");
        }
    }

    public static void removeFromMap(@NonNull Map<String, House> housesMap, @NonNull String name) {
        if (!housesMap.containsKey(name)) {
            System.out.println("Map doesn't contain this house");
        } else {
            housesMap.remove(name);
            System.out.println("House remove from map");
        }
    }

    public static House searchingHouse(@NonNull Map<String, House> housesMap, @NonNull String name) {
        House house = housesMap.get(name);
        if (house == null) {
            System.out.println("Map doesn't contain this house");
        } else {
            System.out.println("The sigil of " + house.getName() + " house is " + house.getSigil());
        }

        return house;
    }

    public static void printAllHouses(@NonNull Map<String, House> housesMap) {
        for (Map.Entry<String, House> entry : housesMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
