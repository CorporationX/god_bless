package faang.school.godbless.task_6;

import java.util.HashMap;
import java.util.List;

public class Main {
    private static final HashMap<String, House> map = new HashMap<>();
    public static void main(String[] args) {
        add(new House("Targarien", "Dragon"));
        add(new House("Lannister", "Lion"));
        add(new House("Stark", "Wolf"));
        add(new House("Greyjoy", "Kraken"));

        List<House> houses = getAllHouses();
        printAllHouses(houses);
    }

    public static void add(House house) {
        map.put(house.getName(), house);
    }

    public static void remove(String name) {
        map.remove(name);
    }

    public static House find(String name) {
        return map.get(name);
    }

    public static String getSigilInfo(String name) {
        return map.get(name).getSigil();
    }

    public static List<House> getAllHouses() {
        return map.values().stream().toList();
    }

    public static void printAllHouses(List<House> houses) {
        for (House house : houses) {
            System.out.println(house.getName() + ": " + house.getSigil());
        }
    }
}
