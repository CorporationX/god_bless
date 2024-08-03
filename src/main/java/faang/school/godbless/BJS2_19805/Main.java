package faang.school.godbless.BJS2_19805;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House starks = new House("Старки", "Герб Старков");
        House greyjoys = new House("Грейджои", "Герб Грейджоев");
        House tallis = new House("Талли", "Герб Талли");
        House arrenys = new House("Аррены", "Герб Арренов");
        House lanisters = new House("Ланнистеры", "Герб Ланнистеров");
        House targariens = new House("Таргариены", "Герб Таргариенов");
        House tirels = new House("Тиреллы", "Герб Тереллов");
        House barateons = new House("Баратеоны", "Герб Баратеонов");
        House martels = new House("Мартеллы", "Герб Мартеллов");

        addHouse(arrenys);
        addHouse(lanisters);
        addHouse(targariens);
        addHouse(tirels);
        addHouse(barateons);
        addHouse(martels);
        addHouse(starks);
        addHouse(greyjoys);
        addHouse(tallis);

        printHouseInfo("Таргариены");
        printAllHousesInfo();
        removeHouse(starks.getName());
        removeHouse(martels.getName());
    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void removeHouse(String houseName) {
        houses.remove(houseName);
    }

    public static void printHouseInfo(String houseName) {
        System.out.println(houses.get(houseName).getSigil());
    }

    public static void printAllHousesInfo() {
        houses.forEach((name, house) -> {
            System.out.println(house.getName() + " - " + house.getSigil());
        });
    }
}
