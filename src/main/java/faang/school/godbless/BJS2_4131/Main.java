package faang.school.godbless.BJS2_4131;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> gameOfThronesFamilies = new HashMap<>();

        House stark = new House("Старк", "Волк");
        House lannister = new House("Ланнистер", "Золотой лев");
        House baratheon = new House("Баратеон", "Чёрный коронованный олень, стоящий на задних ногах, на золотом поле");

        addHouse(stark, gameOfThronesFamilies);
        addHouse(lannister, gameOfThronesFamilies);
        addHouse(baratheon, gameOfThronesFamilies);

        printAllHouses(gameOfThronesFamilies);

        removeHouse(stark, gameOfThronesFamilies);
        System.out.printf("Удалили дом \"%s\"", stark.getName());

        printAllHouses(gameOfThronesFamilies);

        System.out.println(findSigil(lannister.getName(), gameOfThronesFamilies));
    }

    public static void addHouse(House house, Map<String, House> target) {
        target.put(house.getName(), house);
    }

    public static void removeHouse(House house, Map<String, House> target) {
        target.remove(house.getName());
    }

    public static String findSigil(String houseName, Map<String, House> target) {
        House house = target.get(houseName);

        if (house == null) {
            throw new IllegalArgumentException(String.format("Дом \"%s\" не найден", houseName));
        }

        return house.getSigil();
    }

    public static void printAllHouses(Map<String, House> target) {
        System.out.println("Список всех домов и их гербов:");

        for (House house : target.values()) {
            System.out.printf("Дом \"%s\", Герб \"%s\".%n", house.getName(), house.getSigil());
        }
    }
}
