package faang.school.godbless.BJS2_4668;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        addHouses("Baratheon", "Олень");
        addHouses("Stark", "Волк");
        addHouses("Lannister", "Лев");

        deleteHouse("Stark");

        getHouse("Baratheon");

        printAllHouses();

    }

    public static void addHouses(String name, String sigil) {
        House house = new House(name, sigil);
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static void getHouse(String name) {
        System.out.println(houses.get(name).getSigil());
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.printf("Название: %s %nГерб: %s %n", entry.getKey(), entry.getValue().getSigil());
        }
    }
}