package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Stark Flag"));
        houses.put("Lannister", new House("Lannister", "Lannister Flag"));
        houses.put("Baraeton", new House("Baraeton", "Baraeton Flag"));
        houses.put("Noname", new House("Noname", "Noname Flag"));

        addNewHouse(houses, "Some house", new House("Some house", "Some house flag"));
        deleteHouseByName(houses, "Some house");
        findHouseFlagByName(houses, "Stark");
        printAllHouses(houses);
    }

    public static void addNewHouse(Map<String, House> houses, String name, House house) {
        Objects.requireNonNull(houses);
        Objects.requireNonNull(house);
        Objects.requireNonNull(name);
        houses.put(name, house);
    }

    public static void deleteHouseByName(Map<String, House> houses, String name) {
        Objects.requireNonNull(houses);
        Objects.requireNonNull(name);
        houses.remove(name);
    }

    public static void findHouseFlagByName(Map<String, House> houses, String name) {
        Objects.requireNonNull(houses);
        Objects.requireNonNull(name);
        House house = houses.get(name);
        if (house != null) {
            System.out.printf("%s flag: %s\n", house.getName(), house.getSigil());
        } else {
            throw new RuntimeException("There is no house with name " + name);
        }
    }

    public static void printAllHouses(Map<String, House> houses) {
        Objects.requireNonNull(houses);
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.printf("%s flag: %s\n", entry.getKey(), entry.getValue().getSigil());
        }
    }
}
