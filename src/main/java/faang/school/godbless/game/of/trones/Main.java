package faang.school.godbless.game.of.trones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, House> houseMap = new HashMap<>();

    static {
        houseMap.put("Starks", new House("Starks", "Wolf"));
        houseMap.put("Boltons", new House("Boltons", "Bloody human"));
        houseMap.put("Barateons", new House("Barateons", "Black deer with crown"));
        houseMap.put("Lanisters", new House("Lanisters", "Lion"));
        houseMap.put("Arrens", new House("Arrens", "White falcon"));
    }

    public static void main(String[] args) {
        printAll();
        System.out.println();

        printSigil("Starks");
    }

    public static void add(House house) {
        houseMap.put(house.getName(), house);
    }

    public static void remove(String houseName) {
        houseMap.remove(houseName);
    }

    public static void printSigil(String houseName) {
        House house = houseMap.get(houseName);
        System.out.println(house.getSigil());
    }

    public static void printAll() {
        houseMap.forEach((key, value) -> System.out.printf("%s - %s%n", key, value.getSigil()));
    }
}
