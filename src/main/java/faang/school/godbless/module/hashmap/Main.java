package faang.school.godbless.module.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, House> NAME_TO_HOUSE = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "I haven't");
        House lannister = new House("Lannister", "watched");
        House barateon = new House("Barateon", "igru prestolov");
        NAME_TO_HOUSE.put(stark.getName(), stark);
        NAME_TO_HOUSE.put(lannister.getName(), lannister);
        NAME_TO_HOUSE.put(barateon.getName(), barateon);

        addHouseToMap("Hello", "World");
        getHouseFromMap("Hello");
        printAllHouses(NAME_TO_HOUSE);
        deleteHouse("Hello");
        printAllHouses(NAME_TO_HOUSE);
    }

    public static void addHouseToMap(String name, String sigil) {
        NAME_TO_HOUSE.putIfAbsent(name, new House(name, sigil));
    }

    public static void deleteHouse(String name) {
        NAME_TO_HOUSE.remove(name);
    }

    public static void getHouseFromMap(String name) {
        printHouse(NAME_TO_HOUSE.get(name));
    }

    public static void printAllHouses(Map<String, House> houses) {
        if (houses == null || houses.isEmpty()) {
            System.out.println("Не добавлено ни одного дома");
            return;
        }
        for (House house : houses.values()) {
            printHouse(house);
        }
    }

    public static void printHouse(House house) {
        if (house == null) {
            System.out.println("Такого дома не существует");
            return;
        }
        System.out.printf("House name: %s. House sigil: %s", house.getName(), house.getSigil());
        System.out.println();
    }
}