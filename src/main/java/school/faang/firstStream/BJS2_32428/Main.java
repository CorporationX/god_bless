package school.faang.firstStream.BJS2_32428;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> WESTEROS_HOUSES = new HashMap<>();

    private static void validation(House house) {
        if (house == null) {
            throw new IllegalArgumentException("house cannot be null");
        }
        if (house.getName().isBlank()) {
            throw new IllegalArgumentException("house name cannot be null");
        }
        if (house.getSigil().isBlank()) {
            throw new IllegalArgumentException("house sigil cannot be null");
        }
    }

    public static void addHouse(House house) {
        validation(house);
        WESTEROS_HOUSES.put(house.getName(), house);
    }

    public static void removeHouse(String houseName) {
        if (WESTEROS_HOUSES.containsKey(houseName)) {
            WESTEROS_HOUSES.remove(houseName);
        } else {
            System.out.println("Дом " + houseName + " не найден");
        }
    }

    public static String findHouse(String houseName) {
        if (WESTEROS_HOUSES.containsKey(houseName)) {
            return WESTEROS_HOUSES.get(houseName).getSigil();
        }
        return null;
    }

    public static void getAllHouses() {
        if (!WESTEROS_HOUSES.isEmpty()) {
            for (House house : WESTEROS_HOUSES.values()) {
                System.out.println(house.getName() + ": " + house.getSigil());
            }
        } else {
            System.out.println("The library is empty!");
        }
    }

    public static void main(String[] args) {
        addHouse(new House("Stark", "A grey dire wolf on a white field"));
        addHouse(new House("Lannister", "A golden lion rampant on a crimson field"));
        addHouse(new House("Baratheon", "A crowned stag black on a field of gold"));
        addHouse(new House("Targaryen", "A red three-headed dragon on a black field"));

        getAllHouses();

        findHouse("Stark");

        removeHouse("Stark");
        findHouse("Stark");

        getAllHouses();
    }
}
