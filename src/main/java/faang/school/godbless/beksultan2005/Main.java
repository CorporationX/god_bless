package faang.school.godbless.beksultan2005;

import java.util.HashMap;
import java.util.Map;


public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static String getSigil(String name) {
        return houses.get(name).getSigil();
    }

    public static void getAllHouse() {
        houses.forEach((key, value) -> System.out.println(key + ": " + value.getSigil()));
    }

    public static void main(String[] args) {

        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Lion"));
        addHouse(new House("Baratheon", "Stag"));
        addHouse(new House("Targaryen", "Dragon"));
        addHouse(new House("Greyjoy", "Kraken"));

        deleteHouse("Baratheon");

        System.out.println(getSigil("Stark"));

        getAllHouse();

    }
}
