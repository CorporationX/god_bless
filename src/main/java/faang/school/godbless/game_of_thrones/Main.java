package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Winter is coming"));

        add(houses, "Lannister", new House("Lannister", "Hear me Roar!"));
        add(houses, "Targaryen", new House("Targaryen", "Fire and Blood"));
        System.out.println(houses);

        remove(houses, "Targaryen");
        System.out.println(houses);

        add(houses, "Baratheon", new House("Baratheon", "Ours is the Fury"));
        printInfoAboutSigilHouse(houses, "Baratheon");

        printAllInfoAboutHouse(houses);
    }

    public static void add(Map<String, House> houses, String name, House house) {
        houses.put(name, house);
    }

    public static void remove(Map<String, House> houses, String name) {
        houses.remove(name);
    }

    public static House search(Map<String, House> houses, String name) {
        return houses.get(name);
    }

    public static void printInfoAboutSigilHouse(Map<String, House> houses, String name) {
        House house = search(houses, name);
        System.out.println(house.getSigil());
    }

    public static void printAllInfoAboutHouse(Map<String, House> houses) {
        houses.forEach((name, house) -> System.out.println(name + " " + house));
    }
}
