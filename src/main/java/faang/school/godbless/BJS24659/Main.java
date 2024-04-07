package faang.school.godbless.BJS24659;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();

        House.addHouse(houses, "Старк", "ГербСтарков");
        House.addHouse(houses, "Ланнистер", "ГербЛанистеров");
        House.addHouse(houses, "Баратеон", "ГербБаратеонов");

        System.out.println("Информация о домах Вестероса:");
        houses.values().forEach(System.out::println);

        House.removeHouse(houses, "Ланнистер");

        System.out.println("\nПосле удаления дома Ланнистер:");
        houses.values().forEach(System.out::println);

        String houseName = "Старк";
        System.out.println("\nПоиск дома по названию \"" + houseName + "\":");
        House.findHouse(houses, houseName);
    }
}
