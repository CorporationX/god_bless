package faang.school.godbless.hashmap.gameofthrones;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

public class Main {
    private static final Map<String, House> HOUSES = new HashMap<>(Map.of(
            "Stark", new House("Stark", "Stark sigil"),
            "Lannister", new House("Lannister", "Lannister sigil"),
            "Baratheon", new House("Baratheon", "Baratheon sigil"))
    );

    public static House addHouse(House house){
        return HOUSES.put(house.getName(), house);
    }

    public static House deleteHouse(String houseName){
        return ofNullable(HOUSES.remove(houseName))
                .orElseThrow(() -> new NoSuchElementException("No house with name " + houseName));
    }

    public static void searchHouse(String houseName){
        var house = getHouse(houseName);
        System.out.printf("House %s has %s", houseName, house.getSigil());
    }
    public static void printHouses() {
        HOUSES.values().forEach(System.out::println);
    }

    private static House getHouse(String houseName) {
        var house = HOUSES.get(houseName);
        if (house == null){
            throw new NoSuchElementException("No house with name " + houseName);
        }
        return house;
    }

    public static void main(String[] args) {
        var house = new House("Ambrose", "Ambrose sigil");
        var houseName = house.getName();

        addHouse(house);
        System.out.printf("House %s is added.\n", houseName);
        printHouses();
        System.out.println("============");

        searchHouse(houseName);
        System.out.println("\n============");

        deleteHouse(houseName);
        System.out.printf("House %s is deleted.\n", houseName);
        printHouses();
    }
}
