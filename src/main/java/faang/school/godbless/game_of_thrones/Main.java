package faang.school.godbless.game_of_thrones;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, House> houseLibrary = new HashMap<>();

//    static {
//        HOUSE_LIBRARY.put("Старк", new House("Старк", "Волк"));
//    }

    public static void main(String[] args) {
        houseLibrary.put("Старк", new House("Старк", "Волк"));
        houseLibrary.put("Ланнистер", new House("Ланнистер", "Лев"));
        houseLibrary.put("Баратеон", new House("Баратеон", "Олень"));

        addHouse(new House("Таргариен", "Дракон"));
        System.out.println(houseLibrary.size());

        removeHouse("Баратеон");
        System.out.println(houseLibrary.size());

        printHouse("Таргариен");

        printAllHouses();
    }

    public static void addHouse(House house) {
        houseLibrary.put(house.getName(), house);
    }

    public static void removeHouse(String houseName) {
        houseLibrary.remove(houseName);
    }

    public static void printHouse(String houseName) {
        System.out.println(houseLibrary.get(houseName));
    }

    public static void printAllHouses() {
        System.out.println(houseLibrary.values());
    }
}