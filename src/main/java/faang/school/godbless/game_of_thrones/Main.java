package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<String, House> map1 = new HashMap<>();

    public static void main(String[] args) {
        map1.put("Stark", new House("Stark", "DireWolf"));
        map1.put("Lanister", new House("Lanister", "Lion"));
        map1.put("Barateon", new House("Barateon", "Deer"));

        System.out.println(getAllHouse(map1));
    }

    public static void addHouse(House house) {
        map1.put(house.getName(), house);
    }

    public static void removeHouse(String name) {
        map1.remove(name);
    }

    public static House getHouse(String name) {
        return map1.get(name);
    }

    public static void getInfoSigil(String name) {
        System.out.println((map1.get(name)).getSigil());
    }

    public static List<House> getAllHouse(Map<String, House> map) {
        return map.values().stream().toList();
    }
}


