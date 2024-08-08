package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static final Map<String, House> houses = new HashMap<>();
    public static void main(String[] args) {
        add(new House("Stark", "Winter is coming"));
        add(new House("Lannister", "Hear me Roar!"));
        add(new House("Targaryen", "Fire and Blood"));
        System.out.println(houses);

        remove("Targaryen");
        System.out.println(houses);

        add(new House("Baratheon", "Ours is the Fury"));
        printInfoAboutSigilHouse("Baratheon");

        printAllInfoAboutHouse();
    }

    public static void add(House house) {
        houses.put(house.getName(), house);
    }

    public static void remove(String name) {
        houses.remove(name);
    }

    public static House search(String name) {
        return houses.get(name);
    }

    public static void printInfoAboutSigilHouse(String name) {
        House house = search(name);
        if (house != null) {
            System.out.println(house.getSigil());
            return;
        }
        System.out.println("House not found");
    }

    public static void printAllInfoAboutHouse() {
        houses.forEach((name, house) -> System.out.println(name + " " + house));
    }
}
