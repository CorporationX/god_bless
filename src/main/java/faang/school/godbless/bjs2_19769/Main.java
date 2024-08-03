package faang.school.godbless.bjs2_19769;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        House stark = new House("Старк", "black");
        House lannister = new House("Ланнистер", "white");
        House barateon = new House("Баратеон ", "blue");

        HashMap<String, House> houses = new HashMap<>();
        houses.put(stark.getName(), stark);
        houses.put(lannister.getName(), lannister);
        houses.put(barateon.getName(),barateon);

        House elon = new House("Elon", "yellow");

        addHouse(houses, elon);
        System.out.println(outputSigil(houses, "Старк"));
        removeHouse(houses, barateon);
        printAllHouses(houses);




    }

    public static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(Map<String, House> houses, House house) {
        houses.remove(house.getName(), house);
    }

    public static String outputSigil(Map<String, House> houses, String name) {
        String sigil = houses.get(name).getSigil();
        return sigil;
    }

    public static void printAllHouses(Map<String, House> houses) {
        for (House house : houses.values()) {
            System.out.println(house.getName() + " " + house.getSigil());
        }
    }

}
