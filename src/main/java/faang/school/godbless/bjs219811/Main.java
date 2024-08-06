package faang.school.godbless.bjs219811;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Targaryen", new House("Targaryen", "Dragon"));
        houses.put("Baratheon", new House("Baratheon", "Deer"));
        houses.put("Lannister", new House("Lannister", "Lion"));

        addHouse(new House("Greyjoy", "Kraken"));
        allHouses();
        deleteHouse("Greyjoy");
        System.out.println(getSigil("Stark"));
        allHouses();
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String houseName) {
        houses.remove(houseName);
    }

    public static String getSigil(String name) {
        return houses.get(name).getSigil();
    }

    public static void allHouses() {
        houses.forEach((name, house) -> System.out.println(house));
    }

}
