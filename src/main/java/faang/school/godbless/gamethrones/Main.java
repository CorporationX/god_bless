package faang.school.godbless.gamethrones;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Старк", new House("Старк","Герб Старка"));
        houses.put("Ланнистер", new House("Ланнистер", "Герб Ланнистера"));
        houses.put("Баратеон", new House("Баратеон", "Герб Баратеона"));
        System.out.println(houses);

        addHouse(houses, new House("СвойДом", "Герб СвоегоДома"));
        System.out.println(houses);

        removeHouse(houses, "Ланнистер");
        System.out.println(houses);

        getSigil(houses, "СвойДом");
        getHouses(houses);
    }

    public static void addHouse(Map<String, House> houses, House house) {
        houses.put(house.name(), house);
    }

    public static void removeHouse(Map<String, House> houses, String houseName) {
        houses.remove(houseName);
    }

    public static void getSigil(Map<String, House> houses, String houseName) {
        House house = houses.get(houseName);
        if (house != null) {
            System.out.println(house.sigil());
        } else {
            System.out.println("Введён некорректный дом");
        }
    }

    public static void getHouses(Map<String, House> houses) {
        System.out.println("Список домов:");
        for (Map.Entry<String, House> houseEntry : houses.entrySet()) {
            System.out.println(houseEntry.getValue());
        }
    }
}
