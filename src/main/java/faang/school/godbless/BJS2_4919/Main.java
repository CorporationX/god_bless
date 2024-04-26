package faang.school.godbless.BJS2_4919;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, House>families = new HashMap<>();

        House stark = new House("Старк", "Волк");
        House lannister = new House("Ланниcтер", "Золотой лев");
        House baratheon = new House("Баратеон", "Чёрный коронованный олень");

        addHouse(stark, families);
        addHouse(lannister, families);
        addHouse(baratheon, families);
        printAllHouses(families);
        removeHouse(baratheon, families);
        System.out.printf("Удалили дом " + baratheon.getName());
        printAllHouses(families);
        System.out.println(findSigil(lannister.getName(), families));
    }

    public static void addHouse(House house, Map<String, House> target) {
        target.put(house.getName(), house);
    }

    public static void removeHouse(House house, Map<String, House> target) {
        target.remove(house.getName(), house);
    }

    public static String findSigil(String houseName, Map<String, House> target) {
        House house = target.get(houseName);
        if (house == null) {
            throw new IllegalArgumentException(String.format("Дом \"%s\" не найден", houseName));
        }
        return house.getSigil();
    }

    public static void printAllHouses(Map<String, House> houses) {
        System.out.println("Спиcок домов и гербов:");
        StringBuilder result = new StringBuilder();

        for (House house: houses.values()) {
            result.append("Дом: ").append(house.getName()).append("; ");
            result.append("Герб: ").append(house.getSigil()).append(System.lineSeparator());
        }
        System.out.println(result);
    }
}
