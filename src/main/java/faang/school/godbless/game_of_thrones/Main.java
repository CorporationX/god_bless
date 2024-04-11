package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static Map<String, House> COUNTY = new HashMap<>();

    public static void main(String[] args) {
        COUNTY.put("Stark", new House("Stark", "DireWolf"));
        COUNTY.put("Lanister", new House("Lanister", "Lion"));
        COUNTY.put("Barateon", new House("Barateon", "Deer"));

        System.out.println(COUNTY);

        addHouse(new House("Lanister", "Lion"));

        System.out.println(COUNTY);
    }

    public static void addHouse(House house) {
        if (COUNTY.containsKey(house.getName())) {
            throw new IllegalArgumentException("There is already such a house in the county.");
        }
        COUNTY.put(house.getName(), house);
    }

    public static void removeHouse(String name) {
        if (!COUNTY.containsKey(name)) {
            throw new IllegalArgumentException("There is no such house in the county.");
        }
        COUNTY.remove(name);
    }

    public static House getHouse(String name) {
        return COUNTY.get(name);
    }

    public static void getInfoSigil(String name) {
        System.out.println((COUNTY.get(name)).getSigil());
    }

    public static List<House> getAllHouse(Map<String, House> map) {
        return map.values().stream().toList();
    }
}