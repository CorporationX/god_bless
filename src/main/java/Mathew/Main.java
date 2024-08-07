package Mathew;

import java.util.HashMap;
import java.util.List;

public class Main {
    private static HashMap<String, House> houses = new HashMap<>();

    public static House addNewHouse(String name, String sigil) {

        return houses.put(name, new House(name, sigil));
    }

    public static void removeHouse(String name) {

        houses.remove(name);
    }

    public static String searchHouse(String name) {

        return houses.get(name).getSigil();
    }

    public static void returnAllHouses() {
        houses.forEach((key, value) -> System.out.println(key + value.getSigil()));

    }

    public static void main(String[] args) {
        House lanister = new House("Lanister", "Lion");
        House stark = new House("Stark", "Eagle");
        House barateon = new House("Barateon", "Bear");
        houses.put(lanister.getName(), lanister);
        houses.put(stark.getName(), stark);
        houses.put(barateon.getName(), barateon);

        returnAllHouses();
        searchHouse("Barateon");
        removeHouse("Stark");
        addNewHouse("Nagoya", "Fox");
    }
}
