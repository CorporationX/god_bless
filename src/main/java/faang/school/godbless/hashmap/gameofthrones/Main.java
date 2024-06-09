package faang.school.godbless.hashmap.gameofthrones;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public Map<String, House> houses = new HashMap<>(Map.of(
            "Stark", new House("Stark", "Stark sigil"),
            "Lannister", new House("Lannister", "Lannister sigil"),
            "Baratheon", new House("Baratheon", "Baratheon sigil"))
    );

    public House addHouse(House house){
        return houses.put(house.getName(), house);
    }

    public House deleteHouse(String houseName){
        var house = getHouse(houseName);
        return houses.remove(house);
    }

    public void searchHouse(String houseName){
        var house = getHouse(houseName);
        System.out.printf("House %s has %s", houseName, house.getSigil());
    }
    public void printHouse() {
        houses.values().forEach(System.out::println);
    }

    private House getHouse(String houseName) {
        var house = houses.get(houseName);
        if (house == null){
            throw new NoSuchElementException("No house with name " + houseName);
        }
        return house;
    }
}
